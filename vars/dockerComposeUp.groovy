def call (Map config)
{
    node
        {
          stage('Docker compose up')
                {  
                    sh "${config.dockerComposLocation} up "
                }
         }
    
}