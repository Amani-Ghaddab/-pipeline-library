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

            {   sh "whoami"
               
                sh " ls -la ${pwd()}"
                sh " /usr/local/bin/docker-compose up -d"
                sh " mkdir -p ${config.destinationFile} "
                sh " cp -r Source/${config.projectName} ${config.destinationFile}"
                sh " cp -r ${config.dockerComposeLocation} ${config.dockerFileLocation} ${config.nginxLocation} ${config.destinationFile}"
                sh " ls ${config.destinationFile}"
            }  
        stage('Docker build')
                {  
                    sh " /usr/local/bin/docker-compose up -d"
                }
    }
}