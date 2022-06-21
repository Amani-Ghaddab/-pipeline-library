def call (Map config)
{
    node
        {
             when {
                environment name:'APPROVED_DEPLOY', value: 'yes'
            }
         stage('Docker build and up')
                {  
                    sh " ${config.dockerComposeLocation}/docker-compose -f ${config.dockerComposeFileDestination} -p ${config.containerName} up -d --build "
                }
         }
    
}