pipeline {
    agent any 

    stages {
        stage('Build') {
            steps {
                echo 'Building'
                sh "mvn clean package -Dmaven.test.skip=true"
            }
        }
        stage('Test') {
            steps {
                sh "mvn test"
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying....'
            }
        }
    }
}