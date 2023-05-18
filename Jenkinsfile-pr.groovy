pipeline {
    agent any

    stages {
		
		stage('Stage 1') {
             userInput = input(
				id: 'userInput', message: "Some important question?", parameters: [
				booleanParam(defaultValue: false, description: 'really?', name: 'myValue')
			])
        }
         
        
        stage('Stage 2') {
            steps {
                echo 'Segundo stage'
            }
        }
    }
}
