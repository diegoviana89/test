    def executeStage = "no"
pipeline {
    agent any

    stages {
		stage('Stage 1') {
            steps {
                script {
                    executeStage = input(
                        id: 'executeStage',
                        message: 'Do you want to deploy version to DEV?',
                        parameters: [
                                choice(defaultValue: false, choices: ['yes', 'no'],description: 'yes to confirm/empty to skip this stage?', name: 'Yes')
                        ]
                )
                
                if(executeStage=='yes'){
                    echo 'Primer stage'
                }else{
                    
                    echo 'Skipped'
                    currentBuild.result = "SUCCESS"
                }

                }
            }
        }
         
        
        stage('Stage 2') {
            when {
                expression { executeStage == 'yes' }
            }
            steps {
                echo 'Segundo stage'
            }
        }
    }
}
