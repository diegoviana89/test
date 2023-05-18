def executeStage = "no"
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
                                choice(defaultValue: false, choices: ["yes", "no"],description: 'yes to confirm/empty to skip this stage?', name: 'Yes')
                        ])
                    }
                }
            }

		stage('Stage 1') {
            when {
                expression { executeStage == "yes" }
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
                                choice(defaultValue: false, choices: ["yes", "no"],description: 'yes to confirm/empty to skip this stage?', name: 'Yes')
                        ])
                    }
                }
            }
         
        
        stage('Stage 2') {
            when {
                expression { executeStage == "yes" }
            }
            steps {
                echo 'Segundo stage'
            }
        }
    }
}
