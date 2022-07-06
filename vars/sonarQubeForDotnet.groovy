def call (Map config)
{

    node
        {
    
       stage('quality code analysis') {
            when { env.test=='false'
               sh 'echo hello' + env.test
            }
             def scannerHome = tool "${config.SonarScannerMSBuildTool}"
             withSonarQubeEnv("${config.SonarQubeEnv}") { 
                 dir("Source/${config.projectName}") {
                    sh " ls -la ${pwd()}"
                    sh "dotnet ${scannerHome}/SonarScanner.MSBuild.dll begin /k:\"${config.projectName}\" /d:sonar.login=${config.sonarLogin}"
                    sh "dotnet build"
                    sh "dotnet ${scannerHome}/SonarScanner.MSBuild.dll end /d:sonar.login=${config.sonarLogin}"}
                
             }}
      }
        }
        
}

   
  
