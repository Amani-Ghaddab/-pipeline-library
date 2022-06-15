def call (Map config)
{
    node
        {
        def scannerHome = tool 'SonarScanner'
             withSonarQubeEnv('SonarQube') { 
                 dir("Source/${config.projectName}") {
              
                
                    sh "${scannerHome}/bin/sonar-scanner -Dsonar.projectKey=AosoFront -Dsonar.login=51185a986fc11812abcbae108d6a72a6ff5d031e"      
                              }
                // timeout(time: 10, unit: 'MINUTES') {
                //     waitForQualityGate abortPipeline: true
                 }
        
        }
        
}
