pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                mvn -Dmaven.test.skip=true clean package
            }
        }
        stage('Test') {
            steps {
                mvn test
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying....'
            }
        }
    }
}