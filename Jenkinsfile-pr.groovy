pipeline {
    agent any

    stages {
		
		stage('Stage 1') {
            steps {
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
