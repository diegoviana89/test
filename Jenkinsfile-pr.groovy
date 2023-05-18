pipeline {
    agent any

    stages {
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
