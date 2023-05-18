pipeline {
    agent any

    stages {
		
		stage('Stage 1') {
             userInput = input(
				id: 'userInput', message: "Some important question?", parameters: [
				booleanParam(defaultValue: false, description: 'really?', name: 'myValue')
			])
        }
         
        
        stage('optional: do magic') {
			if (userInput) {
				echo "do magic"
			} else {
				// do what ever you want when skipping this build
				currentBuild.result = "UNSTABLE"
			}
		}
    }
}
