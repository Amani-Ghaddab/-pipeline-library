ef call (Map config)
{

    node
        {
        environment {
        scannerHome = tool 'SonarQubeScanner'
    }
          stage('quality code analysis') {
              
                withSonarQubeEnv('sonarqube') {
/k:Aoso /d:sonar.host.url= http://192.168.56.113:9000"

                    sh "${scannerHome}/bin/sonar-scanner -Dsonar.projectKey=AosoFront -Dsonar.login=23b5d4c1c1f76c539f1d0019945228a4003d6a51"                }
                // timeout(time: 10, unit: 'MINUTES') {
                //     waitForQualityGate abortPipeline: true
                // }
            }
          }
        }
