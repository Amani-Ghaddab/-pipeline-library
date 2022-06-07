def call (Map config)
{
    node
        {
          stage("gitCheckout") {
            checkout([$class: 'GitSCM', 
            branches: [[name: 'refs/heads/main']], 
            userRemoteConfigs: [[
                url:"${config.scmurl}"]]
        ])
            
        }
       stage('Sonarqube analysis ') {

     environment { 

             def scannerHome = tool 'SonarScanner 4.10.0'

             MSBUILD_SQ_SCANNER_HOME = tool name: 'sonarscanner', type: 'hudson.plugins.sonar.MsBuildSQRunnerInstallation'

                 }

        steps {

            withSonarQubeEnv('SonarQube') {
                
                dir("Source/${config.projectName}") {
                    sh " ls -la ${pwd()}"

                    sh ("dotnet ${MSBUILD_SQ_SCANNER_HOME}/SonarScanner.MSBuild.dll begin k:'devopsAoso' /d:sonar.host.url='http://localhost:9000'")

                    sh "dotnet build DevOpsProject.csproj"

                    sh "dotnet ${MSBUILD_SQ_SCANNER_HOME}/SonarScanner.MSBuild.dll end"}

       }
       
      
        stage ('create the project directory')
            {   
               
                sh " mkdir -p ${config.destinationFile} "
                sh " cp -r Source/${config.projectName} ${config.destinationFile}"
                sh " cp -r ${config.dockerComposeFileLocation} ${config.dockerFileLocation} ${config.nginxLocation} ${config.destinationFile}"
                sh " ls -la ${config.destinationFile} "
            }  
        stage('Docker build')
                {  
                    sh " ${config.dockerComposeLocation}/docker-compose -f ${config.dockerComposeFileDestination} -p ${config.containerName} up -d --build "
                }
    }

}
        }
}