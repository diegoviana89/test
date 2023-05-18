def executeStage = false
def flag = "yes"
pipeline {
    agent any

    stages {

        stage('Deploy to INT?') {
            agent none
            steps {
                script {
                    executeStage = input(
                        id: 'executeStage',
                        message: 'Do you want to deploy version to DEV?',
                        parameters: [
                                choice( choices: [true, false],description: '"yes" to deploy/"no" to skip?', name: 'choose one option')
                        ])
                    }
                }
            }

		stage('Stage 1') {
            when {
                expression { executeStage = true }
            }
            steps {
                echo 'Primer stage'
            }
        }

        stage('Deploy to DEV?') {
            agent none
            steps {
                script {
                    executeStage = input(
                        id: 'executeStage',
                        message: 'Do you want to deploy version to DEV?',
                        parameters: [
                                choice( choices: ["yes", "no"],description: '"yes" to deploy/"no" to skip?', name: 'choose one option')
                        ])
                    }
                }
            }
         
        
        stage('Stage 2') {
             when {
                expression {
                    return executeStage == "yes" && flag == "yes"
                }
            }
            steps {
                echo 'Segundo stage'
            }
        }
    }
}
