pipeline {
    agent { docker { image 'maven:3.8.4-openjdk-11-slim' } }

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