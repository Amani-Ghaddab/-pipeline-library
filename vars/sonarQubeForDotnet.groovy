def call (Map config)
{

    node
        {
       stage('quality code analysis') {
    //withCredentials([string(credentialsId: 'adminsonarqube', variable: 'ADMIN_SONNARQUBE')]) {
            
         def scannerHome = tool "${config.SonarScannerMSBuildTool}"
             withSonarQubeEnv("${config.SonarQubeEnv}") { 
                 dir("Source/${config.projectName}") {
                    sh " ls -la ${pwd()}"
                    sh "dotnet ${scannerHome}/SonarScanner.MSBuild.dll begin /k:\"${config.projectName}\" /d:sonar.login=${config.sonarLogin}"
                    sh "dotnet build"
                    sh "dotnet ${scannerHome}/SonarScanner.MSBuild.dll end /d:sonar.login=${config.sonarLogin}"}
               
             }
      }
     
    //     stage("Quality Gate"){
    //          timeout(time: 1, unit: 'HOURS') { // Just in case something goes wrong, pipeline will be killed after a timeout
           
    //          def qg = waitForQualityGate(webhookSecretId: '') // Reuse taskId previously collected by withSonarQubeEnv
    //          if (qg.status != 'OK') {
    //                 sh" echo $qg "
    //                 error "Pipeline aborted due to quality gate failure: ${qg.status}"
    // }
    //          }
    // }
    stage("Quality gate") {
            steps {
                waitForQualityGate abortPipeline: true
            }
        }
}
}