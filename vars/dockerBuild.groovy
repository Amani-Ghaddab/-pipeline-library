def call (Map config)
{
    node
        {
          stage('Docker build')
                {  
                    sh "docker build -t teeeeeest -f  ./${config.dockerfileLocation}"
                }
         }
    
}