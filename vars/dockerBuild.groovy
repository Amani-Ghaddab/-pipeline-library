def call (Map config)
{
    node
        {
         stage('Docker build and up')
                {  
                    sh " ${config.dockerComposeLocation}/docker-compose -f ${config.dockerComposeFileDestination} -p ${config.containerName} up -d --build "
                }
         }
    
}