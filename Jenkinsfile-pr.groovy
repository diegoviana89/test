def executeStage = "no"
def flag = "yes"
def tre = true
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
                                 choice( choices: ["yes", "no"],description: '"yes" to deploy/"no" to skip?', name: 'choose one option')
                        ])
                    }
                }
            }

		stage('Stage 1') {
            when {
                expression {
                    return executeStage == "yes" && flag == "yes"
                }
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
                    return tre && flag == "yes"
                }
            }
            steps {
                echo 'Segundo stage'
            }
        }
    }
}
