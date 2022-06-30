def call (Map config)
{
    node{
 // dir("/srv/Aoso/DevOps/backend/AosoBack") {
//       sh"ls -a"
// stage('Clean') {
   
//     sh 'dotnet clean'
  
//   }
//   stage('Build') {
  
//     sh 'dotnet build --configuration Release'
//     sh"ls -a"
 
//   }
//   stage('Pack') {

//     sh 'dotnet pack --no-build --output nupkgs'
//   }
//   stage('Publish') {
  
//     sh "dotnet nuget push nupkgs/*.nupkg -s http://localhost:8081/repository/AosoBack/ -k f25611e8-6ecc-3587-b95c-6be0ec3248ee"
   
//         }  
//  dir ("/srv/Aoso/DevOps/backend"){
//     environment {
//         imageName = "back"
//         registryCredentials = "nexus"
//         registry = "ec2-13-58-223-172.us-east-2.compute.amazonaws.com:8085/"
//         dockerImage = ''
//     }
    
    
//     // Building Docker images
//     stage('Building image') {
    
//         script {
//           dockerImage = docker.build back
//         }
      
//     }

//     // Uploading Docker images into Nexus Registry
//     stage('Uploading to Nexus') {
    
//          script {
//              docker.withRegistry( 'http://'+registry, registryCredentials ) {
//              dockerImage.push('latest')
//           }
        
//       }
//     }
    
//     // Stopping Docker containers for cleaner Docker run
//     stage('stop previous containers') {
        
//             sh 'docker ps -f name=back -q | xargs --no-run-if-empty docker container stop'
//             sh 'docker container ls -a -fname=back -q | xargs -r docker container rm'
         
//        }
      
//     stage('Docker Run') {
     
//          script {
//                 sh 'docker run -d -p 80:80 --rm --name back ' + registry + imageName
//             }
         
//       }    
//     }
   stage('Creating our image'){      
                        //def version = "latest"
                        //sh 'docker build -f "${config.Dockerfile}" -t nexus_docker/aoso '
                   
                            
                            
                    
                        stage('push image in nexus'){      
                            sh "ls -la"
                            dockerImage = docker.build "docker_back/front" + ":latest" 
                            
                                //def version = "latest"
                                //sh 'docker build -f "${config.Dockerfile}" -t nexus_docker/aoso '
                                docker.withRegistry( 'http://localhost:8082/repository/dockerForBack', 'docker_back' ) { 
                                    dockerImage.push() 
                                } 
                             }
        }
}

     
}
