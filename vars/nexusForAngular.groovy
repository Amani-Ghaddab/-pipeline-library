def call (Map config)
{
    node{
  dir("Source/AosoFront") {
      sh"ls -a"

  stage('Build') {
  
    sh 'ng build'
 
  }
  stage('Creating our image'){      
                        //def version = "latest"
                        //sh 'docker build -f "${config.Dockerfile}" -t nexus_docker/aoso '
                     dir ("/srv/Aoso/DevOps/frontend"){
                        dockerImage = docker.build "docker_front/aoso_front" + ":latest"
                    }
   stage('push image in nexus'){      
             docker.withRegistry( 'http://localhost:8083/repository/dockerForFront', 'nexus' ) { 
            dockerImage.push() 
                                } 
                             }
}
  // stage('Pack') {
  
  //   sh 'cd dist/DevOpsFront'
  //   sh' npm pack'
  //   sh'npm publish'
  //  //sh" npm publish --registry http://localhost:8081/repository/npm-private/ "
  // //  sh"npm login -u admin -p 123456 --registry http://localhost:8081/repository/npm-registry/"
  // //  sh'npm publish'
  // }
  
        
}
     
    
}}