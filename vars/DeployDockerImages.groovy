def call (Map config)
{
    node
        {
        stage('Sonarqube analysis ') {

    //  environment { 

    //     //     //def scannerHome = tool 'SonarScanner 4.10.0'

    //          MSBUILD_SQ_SCANNER_HOME = tool name: 'sonarscanner', type: 'hudson.plugins.sonar.MsBuildSQRunnerInstallation'

    //              }

        // steps {

            withSonarQubeEnv('sonarserver') {

                sh 'dotnet restore'

                sh ("""dotnet ${MSBUILD_SQ_SCANNER_HOME}/SonarScanner.MSBuild.dll begin /k:'app_key'""")

                sh "dotnet build app.sln"

                sh "dotnet ${MSBUILD_SQ_SCANNER_HOME}/SonarScanner.MSBuild.dll end"
// dotnet tool install --global dotnet-sonarscanner
// dotnet sonarscanner begin /k:"project-key" /d:sonar.login="<token>"
// dotnet build <path to solution.sln>
// dotnet sonarscanner end /d:sonar.login="<token>"
      //  }
        }
        }
        // stage("gitCheckout") {
        //     checkout([$class: 'GitSCM', 
        //     branches: [[name: 'refs/heads/main']], 
        //     userRemoteConfigs: [[
        //         url:"${config.scmurl}"]]
        // ])
        // }
        // stage ('create the project directory')
        //     {   
        //         sh " ls -la ${pwd()}"
        //         sh " mkdir -p ${config.destinationFile} "
        //         sh " cp -r Source/${config.projectName} ${config.destinationFile}"
        //         sh " cp -r ${config.dockerComposeFileLocation} ${config.dockerFileLocation} ${config.nginxLocation} ${config.destinationFile}"
        //         sh " ls -la ${config.destinationFile} "
        //     }  
        // stage('Docker build')
        //         {  
        //             sh " ${config.dockerComposeLocation}/docker-compose -f ${config.dockerComposeFileDestination} -p ${config.containerName} up -d --build "
        //         }
    }

}