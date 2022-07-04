def call (Map config)
{
    node
        {
      
        stage ('create the local project directory')
            {   
               // sh "ssh -oStrictHostKeyChecking=no amani@192.168.1.19 'mkdir -p /srv/Aoso/DevOps/backend'"
                sh " mkdir -m ${config.destinationFolder} "
                sh " cp -r Source/${config.projectName} ${config.destinationFolder}"
                sh " cp -r ${config.dockerComposeFileLocation} ${config.dockerFileLocation} ${config.nginxLocation} ${config.destinationFolder}"
                sh " ls -la ${config.destinationFolder} "
               
            }  
        
     }
}
