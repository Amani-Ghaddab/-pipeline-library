ef call (Map config)
{

    node
        {
          stage('quality code analysis') {
           
                def scannerHome = tool 'SonarQubeScanner'
                withSonarQubeEnv('SonarQube') {
                    sh "${scannerHome}/bin/sonar-scanner"
                }
            
        }
    }
}