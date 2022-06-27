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
    sh "ng build --aot --prod"
    //sh'npm publish'
   // sh" npm publish --registry http://localhost:8081/repository/AosoFront/ "
   sh"npm publish --registry http://your-host:8081/repository/npm-group"
  }
  
        
}
     
    
}}