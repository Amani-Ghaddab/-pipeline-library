def call (Map config)
{
    node{
  dir("Source/AosoFront") {
      sh"ls -a"

  stage('Build') {
  
    sh 'ng build'
 
  }
  stage('Creating our image'){      
                        dir ("/srv/Aoso/DevOps/frontend"){
                        dockerImage = docker.build "docker_front/aoso_front" + ":latest"
                    }
   stage('push image in nexus'){      
             docker.withRegistry( 'http://localhost:8083/repository/dockerForFront', 'nexus' ) { 
            dockerImage.push() 
                                } 
                             }
}       
}
     
    
}}