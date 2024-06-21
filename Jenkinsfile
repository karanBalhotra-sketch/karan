pipeline {
    agent any

    environment {
        EMAIL_RECIPIENT = 'karanbalhotra@gmail.com'
    }

    stages {
        stage('Build') {
            steps {
                bat 'python -m compileall main.py'
            }
        }
        stage('Unit and Integration Tests') {
            steps {
                bat 'echo Running unit and integration tests...'
            }
        }
        stage('Code Analysis') {
            steps {
                bat 'echo Analyzing code...'
            }
        }
        stage('Security Scan') {
            steps {
                bat 'echo Performing security scan...'
            }
        }
        stage('Deploy to Staging') {
            steps {
                bat 'echo Deploying to staging...'
            }
        }
        stage('Integration Tests on Staging') {
            steps {
                bat 'echo Running integration tests on staging...'
            }
        }
        stage('Deploy to Production') {
            steps {
                bat 'echo Deploying to production...'
            }
        }
    }

    post {
        always {
            script {
                emailext(
                    subject: "Pipeline Notification: ${currentBuild.currentResult}",
                    body: "The Jenkins pipeline has completed with status: ${currentBuild.currentResult}.",
                    recipientProviders: [[$class: 'DevelopersRecipientProvider']],
                    to: "${env.EMAIL_RECIPIENT}"
                )
            }
        }
    }
}
