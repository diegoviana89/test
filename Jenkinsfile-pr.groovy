pipeline {
    agent any
    
    stages {
        stage('Stage 1') {
            steps {
                script {
                    // Solicitar confirmación al usuario
                    def userInput = input(
                        id: 'userConfirmation',
                        message: '¿Deseas ejecutar el Stage 1?',
                        parameters: [
                            [$class: 'ChoiceParameterDefinition', choices: 'Sí\nNo', description: 'Selecciona una opción']
                        ]
                    )
                    
                    // Verificar la respuesta del usuario
                    if (userInput == 'Sí') {
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
                echo 'Ejecutando Stage 2...'
                // Agrega aquí las instrucciones para el Stage 2
            }
        }
    }
}
