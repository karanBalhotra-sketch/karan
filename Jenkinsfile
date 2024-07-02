pipeline {
    agent any
    tools {
        maven 'maven' // Ensure this matches the name in your Global Tool Configuration
    }
    stages {
        stage('Checkout the project') {
            steps {
                git branch: 'main', url: 'https://github.com/karanBalhotra-sketch/karan.git'
            }
        }
        stage('Build') {
            steps {
                script {
                    if (fileExists('pom.xml')) {
                        echo 'pom.xml found, proceeding with build.'
                        sh 'mvn clean package'
                    } else {
                        error 'pom.xml not found in the workspace.'
                    }
                }
            }
        }
        stage('Test') {
            steps {
                script {
                    if (fileExists('pom.xml')) {
                        echo 'pom.xml found, proceeding with tests.'
                        sh 'mvn test'
                    } else {
                        error 'pom.xml not found in the workspace.'
                    }
                }
            }
        }
        stage('Package') {
            steps {
                script {
                    if (fileExists('pom.xml')) {
                        echo 'pom.xml found, creating JAR file.'
                        sh 'mvn package' // This command creates the JAR file
                    } else {
                        error 'pom.xml not found in the workspace.'
                    }
                }
                post {
                    success {
                        archiveArtifacts(artifacts: '**/target/*.jar', allowEmptyArchive: true)
                    }
                }
            }
        }
    }
}
