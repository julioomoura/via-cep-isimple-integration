pipeline {
    agent { docker { image 'maven:3.8.4-openjdk-11-slim' } }

    stages {
        stage('Build') {
            steps {
                echo 'Building'
                mvn clean package -Dmaven.test.skip=true
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