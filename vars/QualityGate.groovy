def call (Map config)
{

    node
        {
         
           stage("Quality gate") {
             
          def qualitygate = waitForQualityGate()
         
          if (qualitygate.status != "OK") {
            waitForQualityGate abortPipeline: true
                
      
            error "Pipeline aborted due to quality gate failure: ${qualitygate.status}"
          }
         
           }

            
        }
}