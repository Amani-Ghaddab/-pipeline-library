def call (Map config)
{
    node
        {
          stage('Docker compose up')
                {  
                    sh "Docker-compose up "
                }
         }
    
}