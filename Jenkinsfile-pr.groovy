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
          if(executeStage){
             echo 'Primer stage'
          }else{
             echo 'Skipped'
            currentBuild.result = "NOT_BUILT"
          }

        }
      }
        }
         
        
        stage('Stage 2') {
            steps {
                echo 'Segundo stage'
            }
        }
    }
}
