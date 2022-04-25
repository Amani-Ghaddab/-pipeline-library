def call (Map config)
{
    node
        {
          stage('Docker compose up')
                {  
                    sh"docker stop c934588bb7326960e8575b1df60eff2877cbc6db3378f11c76eaced064aefea7"
                    sh "docker rm c934588bb7326960e8575b1df60eff2877cbc6db3378f11c76eaced064aefea7"
                    sh "${config.dockerComposLocation} up "
                }
         }
    
}