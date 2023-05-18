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
                         booleanParam(defaultValue: false, description: 'really?', name: 'myValue')
                  ]
          )
          if(executeStage){
             echo 'Segundo stage'
          }else{
             echo 'Skipped'
            currentBuild.result = "UNSTABLE"
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
