pipeline {
    agent any

    stages {
		
		stage('Deploy to INT?') {
            agent none
            steps {
                input(message: "Do you want to deploy version ${params.BUILD_VERSION} to INT?")
            }
            post {
                success {
                    echo 'Attempting to deploy to int'
                }
                aborted {
                    echo "Aborting attempt to deploy to int"
                }
            }
        }
        
        stage('Stage 1') {
            steps {
                echo 'Hola'
            }
        }
        
        stage('Stage 2') {
            steps {
                echo 'Segundo stage'
            }
        }
    }
}
