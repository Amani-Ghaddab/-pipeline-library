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
         //def MSBUILD_SQ_SCANNER_HOME = tool name: 'sonarscanner', type: 'hudson.plugins.sonar.MsBuildSQRunnerInstallation';

             withSonarQubeEnv('SonarQube') {
                 dir("Source/${config.projectName}") {
                    sh " ls -la ${pwd()}"
                   // sh "dotnet tool install --global dotnet-sonarscanner"
                   sh ("""${scannerHome}/bin/sonar-scanner begin -D /k:'AosoDevops' -D /d:sonar.host.url='http://localhost:9000' -D /d:sonar.login="23b5d4c1c1f76c539f1d0019945228a4003d6a51""")

                    sh "dotnet build DevOpsProject.csproj"

                    sh "${scannerHome}/bin/sonar-scanner end"}

     
       
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