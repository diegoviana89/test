pipeline {
    agent any

    stages {
		stage('Deploy to Dev') {
      steps {
        script {
          def executeStage = input(
                  id: 'userInput', message: "Some important question?", parameters: [
					booleanParam(defaultValue: false, description: 'really?', name: 'myValue')
          )
          if(executeStage){
            echo 'Segundo stage'
          }else{
            echo "deployment skipped"
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
