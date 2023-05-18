pipeline {
    agent any

    stages {
		stage('Stage 1') {
            steps {
			userInput = input(
				id: 'userInput', message: "Some important question?", parameters: [
				booleanParam(defaultValue: false, description: 'really?', name: 'myValue')
			])
				if (userInput) {
			echo "do magic"
		} else {
			// do what ever you want when skipping this build
			currentBuild.result = "UNSTABLE"
		}
                echo 'Segundo stage'
            }
        }
         
        
        stage('Stage 2') {
            steps {
                echo 'Segundo stage'
            }
        }
    }
}
