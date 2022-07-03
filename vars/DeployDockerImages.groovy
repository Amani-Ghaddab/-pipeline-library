def call (Map config)
{
    node
        {
      
        stage ('create the local project directory')
            {   
                sh "ssh amani@41.225.43.141' mkdir -p /srv/Aoso/DevOps/backend'"
                //sh " mkdir -p ${config.destinationFolder} "
                sh " cp -r Source/${config.projectName} ${config.destinationFolder}"
                sh " cp -r ${config.dockerComposeFileLocation} ${config.dockerFileLocation} ${config.nginxLocation} ${config.destinationFolder}"
                sh " ls -la ${config.destinationFolder} "
               
            }  
        
     }
}
