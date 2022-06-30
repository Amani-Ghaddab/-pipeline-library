def call (Map config)
{
    node{
  dir("Source/AosoFront") {
      sh"ls -a"

  stage('Build') {
  
    sh 'ng build'
 
  }
  stage('Pack') {
  
    sh 'cd dist/DevOpsFront'
    sh' npm pack'
    //sh'npm publish'
   sh" npm publish --registry http://localhost:8081/repository/npm-registry/ "
  //  sh"npm login -u admin -p 123456 --registry http://localhost:8081/repository/npm-registry/"
  //  sh'npm publish'
  }
  
        
}
     
    
}}