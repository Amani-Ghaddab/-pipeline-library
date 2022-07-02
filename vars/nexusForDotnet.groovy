def call (Map config)
{
    node{
   stage('Creating our image'){      
                        //def version = "latest"
                        //sh 'docker build -f "${config.Dockerfile}" -t nexus_docker/aoso '
                    // dir ("/srv/Aoso/DevOps/backend"){
                     sh'cd Scripts/Back'
                        dockerImage = docker.build "docker_back/aoso_back" + ":latest" --no-cache
                    
   stage('push image in nexus'){      
             docker.withRegistry( 'http://localhost:8082/repository/dockerForBack', 'nexus' ) { 
            dockerImage.push() 
                                } 
                             }
        }
}

     
}
