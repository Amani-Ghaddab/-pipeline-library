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
       stage('SonarQube analysis') {
         def scannerHome = tool 'sonarscanner';
         def MSBUILD_SQ_SCANNER_HOME = tool name: 'sonarScanner', type: 'hudson.plugins.sonar.MsBuildSQRunnerInstallation';

             withSonarQubeEnv('SonarQube') {
                 dir("Source/${config.projectName}") {
                    sh " ls -la ${pwd()}"
                   // sh "dotnet tool install --global dotnet-sonarscanner"
                   sh ("${scannerHome}/bin/sonar-scanner begin /k:AosoDevops /d:sonar.host.url=http://localhost:9000")

                    sh "dotnet build DevOpsProject.csproj"

                    sh "dotnet ${scannerHome}/SonarScanner.MSBuild.dll end"}

     
       
      }
    //     stage ('create the project directory')
    //         {   
               
    //             sh " mkdir -p ${config.destinationFile} "
    //             sh " cp -r Source/${config.projectName} ${config.destinationFile}"
    //             sh " cp -r ${config.dockerComposeFileLocation} ${config.dockerFileLocation} ${config.nginxLocation} ${config.destinationFile}"
    //             sh " ls -la ${config.destinationFile} "
    //         }  
    //     stage('Docker build')
    //             {  
    //                 sh " ${config.dockerComposeLocation}/docker-compose -f ${config.dockerComposeFileDestination} -p ${config.containerName} up -d --build "
    //             }
     }


        }
}