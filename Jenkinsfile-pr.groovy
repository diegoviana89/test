def executeStage = false
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
                                choice(defaultValue: false, choices: [true, false],description: 'yes to confirm/empty to skip this stage?', name: 'Yes')
                        ])
                    }
                }
            }

		stage('Stage 1') {
            when {
                expression { executeStage == true }
            }
            steps {
                echo 'Segundo stage'
            }
        }
         
        
        stage('Stage 2') {
            when {
                expression { executeStage == true }
            }
            steps {
                echo 'Segundo stage'
            }
        }
    }
}
