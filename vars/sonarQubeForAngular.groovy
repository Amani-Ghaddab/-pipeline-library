ef call (Map config)
{
    node
        {
        def scannerHome = tool 'SonarScanner'
             withSonarQubeEnv('SonarQubeScanner') { 
                 dir("Source/${config.projectName}") {
              
                
                    sh "${scannerHome}/bin/sonar-scanner -Dsonar.projectKey=AosoFront -Dsonar.login=23b5d4c1c1f76c539f1d0019945228a4003d6a51"      
                              }
                // timeout(time: 10, unit: 'MINUTES') {
                //     waitForQualityGate abortPipeline: true
                 }
        
        }
        
}
