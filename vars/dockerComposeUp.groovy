def call (Map config)
{
    node
        {
            input {
                message "Ready to deploy?"
                ok "Yes"
            }
          stage('Docker compose up')
                {  
                
                    sh "${config.dockerComposLocation} up -d "
                }
         }
    
}