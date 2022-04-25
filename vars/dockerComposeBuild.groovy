def call (Map config)
{
    node
        {
          stage('Docker build')
                {  
                    sh "${config.dockerComposLocation} up "
                }
         }
    
}