pipeline {
    agent any

    stages {
		
		stage('Deploy to Dev') {
  
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
					echo "stage 1"
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
