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
                          [$class: 'BooleanParameterDefinition', description: 'deploy to dev', name: 'deployToDev']
                  ]
          )
          if(executeStage){
             echo 'Segundo stage'
          }else{
            echo "deployment skipped"
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
