pipeline {
    agent any

    stages {
		stage('Stage 1') {
            steps {
                script {
                def executeStage = input(
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
            when{
                executeStage = 'no'
            }
            steps {
                echo 'Segundo stage'
            }
        }
    }
}
