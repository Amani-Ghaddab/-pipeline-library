def call (Map config)
{

    node
        {
       stage ("install sonarqube"){
           sh " /usr/local/bin/docker-compose -f Scripts/Back/sonarQube/docker-compose.yml up -d --build "
                
       }
       stage('quality code analysis') {
    //withCredentials([string(credentialsId: 'adminsonarqube', variable: 'ADMIN_SONNARQUBE')]) {
            
         def scannerHome = tool "${config.SonarScannerMSBuildTool}"
             withSonarQubeEnv("${config.SonarQubeEnv}") { 
                 dir("Source/${config.projectName}") {
                    sh " ls -la ${pwd()}"
                    sh "dotnet ${scannerHome}/SonarScanner.MSBuild.dll begin /k:\"${config.projectName}\" /d:sonar.login=${config.sonarLogin}"
                    sh "dotnet build"
                    sh "dotnet ${scannerHome}/SonarScanner.MSBuild.dll end /d:sonar.login=${config.sonarLogin}"}
                    //println ${env.SONAR_HOST_URL} 
             }
      }
//      stage("Quality Gate"){
//   timeout(time: 1, unit: 'HOURS') { // Just in case something goes wrong, pipeline will be killed after a timeout
//     def qg = waitForQualityGate(webhookSecretId: 'jenkinsSonar') // Reuse taskId previously collected by withSonarQubeEnv
//     if (qg.status != 'OK') {
//       error "Pipeline aborted due to quality gate failure: ${qg.status}"
//     }
   
    stage("Quality gate") {
           def qualitygate = waitForQualityGate()
          sleep(10)
          if (qualitygate.status != "OK") {
            waitForQualityGate abortPipeline: true
            

            
        }
}
    
}
        }
