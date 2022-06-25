pipeline {
    agent any 

    tools { 
        maven 'Maven 3.8.6' 
        jdk 'jdk17' 
    }

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