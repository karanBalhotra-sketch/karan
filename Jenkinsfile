pipeline {
    agent any
    tools {
        maven 'maven'
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
                        def mvnOutput = sh(script: 'mvn test', returnStdout: true).trim()
                        if (mvnOutput.contains("Tests run: 1, Failures: 0, Errors: 0, Skipped: 0")) {
                            echo 'Tests passed!'
                        } else {
                            echo 'TEST NOT PASSED'
                            currentBuild.result = 'FAILURE'
                            error 'Tests did not pass. Failing the build.'
                        }
                    } else {
                        error 'pom.xml not found in the workspace.'
                    }
                }
            }
        }
    }
    post {
        always {
            junit '**/target/surefire-reports/*.xml'
        }
    }
}
