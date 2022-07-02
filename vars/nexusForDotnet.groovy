def call (Map config)
{

    node{
         stage('Creating our image'){      
                        dir ("/srv/Aoso/DevOps/backend"){
                        dockerImage = docker.build "docker_back/aoso_back" + ":latest"
                    }
        stage('push image in nexus'){      
             docker.withRegistry( 'http://localhost:8082/repository/dockerForBack', 'nexus' ) { 
            dockerImage.push() 
                                } 
                             }
      
       
        }
}

     
}
