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

            {   
                sh " ls Source" 
                sh " ls Source/${config.projectName}"
                sh " mkdir -p ~${config.destinationFile} "
                
                sh "cp -r Source/${config.projectName} ~${config.destinationFile}"
                sh "cp -r ${config.dockerComposeLocation} ${config.dockerFileLocation} ${config.nginxLocation} ~${config.destinationFile}"
                sh " ls ~${config.destinationFile}"
                sh " ls ~${config.destinationFile}/nginx"
                sh " ls ~${config.destinationFile}/AosoFront"
            }  
        stage('Docker build')
                {  
                    sh "docker-compose -f ~/Aoso/DevOps/frontend/docker-compose-front.yml up -d"
                }
    }
}