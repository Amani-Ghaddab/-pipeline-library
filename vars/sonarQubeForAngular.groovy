def call (Map config)
{
    node
        {
           stage('quality code analysis') {
            def scannerHome = tool 'SonarScanner'
                withSonarQubeEnv("${config.SonarQubeEnv}") { 
                    dir("Source/${config.projectName}") {
                
                    
                        sh "${scannerHome}/bin/sonar-scanner -Dsonar.projectKey=${config.projectName} -Dsonar.login=${config.sonarLogin}"      
                                }
                    }
        
        }
        
}}
