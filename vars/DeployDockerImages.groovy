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
                 sh "pwd"
             dir("${config.destinationFile} ") {
      sh "pwd"
    }
    sh "pwd"
                sh " mkdir -p ${config.destinationFile} "
                sh " cp -r Source/${config.projectName} ${config.destinationFile}"
                sh " cp -r ${config.dockerComposeLocation} ${config.dockerFileLocation} ${config.nginxLocation} ${config.destinationFile}"
                sh " ls ${config.destinationFile}"
            }  
        stage('Docker build')
                {  
                    sh "docker-compose -f ${config.destinationFile}/docker-compose-back.yml up"
                }
    }
}