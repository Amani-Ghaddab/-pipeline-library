def call (Map config)
{

    node
        {
           stage("Quality gate") {
          def qualitygate = waitForQualityGate()
          sleep(10)
          if (qualitygate.status != "OK") {
            waitForQualityGate abortPipeline: true
            // mail to: "ameni.ghaddabe@gmail.com",
            // subject: "Test Email",
            // body: "Test"
            error "Pipeline aborted due to quality gate failure: ${qualitygate.status}"
          }
          post{
        failure{
            emailext to: "ameni.ghaddabe@gmail.com",
            subject: "jenkins build:${currentBuild.currentResult}: ${env.JOB_NAME}",
            body: "${currentBuild.currentResult}: Job ${env.JOB_NAME}\nMore Info can be found here: ${env.BUILD_URL}"
        }
          }

            
        }
}