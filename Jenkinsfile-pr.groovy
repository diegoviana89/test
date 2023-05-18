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
                         [$class: 'ChoiceParameterDefinition', choices: 'yes\nNo', description: 'Choose one option']
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
