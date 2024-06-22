pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                echo 'Building the project'
                // Typically not required for HTML/CSS projects
            }
        }
        stage('Unit and Integration Tests') {
            steps {
                echo 'Running unit tests'
                // No automated tests specified for HTML/CSS projects
            }
        }
        stage('Code Analysis') {
            steps {
                echo 'Performing code analysis'
                // No specific code analysis tools required for HTML/CSS projects
            }
        }
        stage('Security Scan') {
            steps {
                echo 'Performing security scan'
                // No security scans specified for HTML/CSS projects
            }
        }
        stage('Deploy to Staging') {
            steps {
                echo 'Deploying to staging server'
                // No deployment needed
            }
        }
        stage('Integration Tests on Staging') {
            steps {
                echo 'Running integration tests on staging'
                // No specific integration tests specified for HTML/CSS projects
            }
        }
        stage('Deploy to Production') {
            steps {
                echo 'Deploying to production server'
                // No deployment needed
            }
        }
    }

    post {
        success {
            echo 'Pipeline succeeded! Sending notification email...'
            emailext(
                subject: "Pipeline Notification: ${currentBuild.currentResult}",
                body: """<p>The Jenkins pipeline has completed successfully.</p>
                         <p>Job: ${env.JOB_NAME}</p>
                         <p>Build Number: ${env.BUILD_NUMBER}</p>
                         <p>Build URL: ${env.BUILD_URL}</p>""",
                recipientProviders: [[$class: 'DevelopersRecipientProvider']],
                to: "karanbalhotra@gmail.com"
            )
        }
        failure {
            echo 'Pipeline failed! Sending notification email...'
            emailext(
                subject: "Pipeline Notification: ${currentBuild.currentResult}",
                body: """<p>The Jenkins pipeline has failed. Please check the logs for details.</p>
                         <p>Job: ${env.JOB_NAME}</p>
                         <p>Build Number: ${env.BUILD_NUMBER}</p>
                         <p>Build URL: ${env.BUILD_URL}</p>""",
                recipientProviders: [[$class: 'DevelopersRecipientProvider']],
                to: "karanbalhotra@gmail.com"
            )
        }
    }
}
