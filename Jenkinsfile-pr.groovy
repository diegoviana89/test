pipeline {
    agent any

    stages {
        
        stage('Stage 1') {
            steps {
                script {
                    // Solicitar confirmación al usuario
                    def userInput = input(
                        id: 'userConfirmation',
                        message: 'Deseas ejecutar el Stage 1',
                        parameters: [
                            [$class: 'GeneratorChoiceParameterDefinition', choices: 'Si\No', description: 'Selecciona una opcion']
                        ]
                    )
                    
                    // Verificar la respuesta del usuario
                    if (userInput == 'Si') {
                        echo 'Ejecutando Stage 1...'
                        // Agrega aquí las instrucciones para el Stage 1
                    } else {
                        echo 'Omitiendo Stage 1...'
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
