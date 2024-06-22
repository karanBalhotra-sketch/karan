pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                echo 'Building the project'
            }
        }
        // Other stages...
    }

    post {
        always {
            echo 'Sending notification email...'
            script {
                def emailRecipient = "karanbalhotra@gmail.com"
                def emailSubject = "Pipeline Notification: ${currentBuild.currentResult}"
                def emailBody = """
                    <p>The Jenkins pipeline has completed with status: ${currentBuild.currentResult}</p>
                    <p>Job: ${env.JOB_NAME}</p>
                    <p>Build Number: ${env.BUILD_NUMBER}</p>
                    <p>Build URL: ${env.BUILD_URL}</p>
                """

                // Log email details
                echo "Sending email to: ${emailRecipient}"
                echo "Email subject: ${emailSubject}"
                echo "Email body: ${emailBody}"

                emailext(
                    subject: emailSubject,
                    body: emailBody,
                    to: emailRecipient
                )
            }
        }
    }
}
