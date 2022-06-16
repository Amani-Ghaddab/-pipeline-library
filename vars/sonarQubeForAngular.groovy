def call (Map config)
{
    node
        {
        def scannerHome = tool 'SonarScanner'
             withSonarQubeEnv("${config.SonarQubeEnv}") { 
                 dir("Source/${config.projectName}") {
              
                
                    sh "${scannerHome}/bin/sonar-scanner -Dsonar.projectKey=AosoFront -Dsonar.login=${config.sonarLogin}"      
                              }
                // timeout(time: 10, unit: 'MINUTES') {
                //     waitForQualityGate abortPipeline: true
                 }
        
        }
        
}
