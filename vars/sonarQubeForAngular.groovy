def call (Map config)
{
    node
        {
        def scannerHome = tool 'SonarScanner'
              withSonarQubeEnv("${config.SonarQubeEnv}") { 
                 dir("Source/${config.projectName}") {
              
                
                    sh "${scannerHome}/bin/sonar-scanner -Dsonar.projectKey=${config.projectName} -Dsonar.login=${config.sonarLogin}"      
                              }
                 }
        
        }
        
}
