def call (Map config)
{
//    node{
//   dir("cd Scripts/Back") {  
//        sh"ls -a"
//                         //def version = "latest"
//                         //sh 'docker build -f "${config.Dockerfile}" -t nexus_docker/aoso '
//                     // dir ("/srv/Aoso/DevOps/backend"){
//                      sh'cd Scripts/Back'
//                         dockerImage = docker.build "docker_back/aoso_back" + ":latest" --no-cache
                    
//    stage('push image in nexus'){      
//              docker.withRegistry( 'http://localhost:8082/repository/dockerForBack', 'nexus' ) { 
//             dockerImage.push() 
//                                 } 
//                              }
//         }
// }

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
     
    
}
     
}
