pipeline {
    agent any 

    tools { 
        maven 'MAVEN_HOME' 
        jdk 'JAVA_HOME' 
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