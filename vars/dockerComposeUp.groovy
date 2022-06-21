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
                //   sh"docker stop 357e4e794eb14186fd138e47571cb72618e0e3dbda31d2af82bf3031e2846071"
                   //sh"docker rm 357e4e794eb14186fd138e47571cb72618e0e3dbda31d2af82bf3031e2846071"
                    sh "${config.dockerComposLocation} up -d "
                }
         }
    
}