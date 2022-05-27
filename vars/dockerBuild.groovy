def call (Map config)
{
    node
        {
          stage('Docker build')
                {  
                    sh "docker build  ${config.dockerfileLocation} ."
                }
         }
    
}s