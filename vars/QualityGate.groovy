def call (Map config)
{

    node
        {
           stage("Quality gate") {
          def qualitygate = waitForQualityGate()
          sleep(10)
          if (qualitygate.status != "OK") {
            waitForQualityGate abortPipeline: true
          }
          }
            
        }
}