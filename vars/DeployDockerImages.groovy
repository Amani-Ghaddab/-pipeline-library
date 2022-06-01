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
        stage ('create the project directory')

            {   sh " ls -la ${pwd()}"
                sh " mkdir -p ${config.destinationFile} "
                sh " cp -r Source/${config.projectName} ${config.destinationFile}"
                sh "cp -r ${config.dockerComposeLocation} ${config.dockerFileLocation} ${config.nginxLocation} ${config.destinationFile}"
                sh " ls ${config.destinationFile}/${config.projectName}"
            }  
        // stage('Docker build')
        //         {  
        //             sh "docker-compose -f ~${config.destinationFile}/docker-compose-back.yml up -d"
        //         }
    }
}