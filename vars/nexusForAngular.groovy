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
    //sh' npm pack'
    sh "ng build --aot --prod"
    //sh'npm publish'
    sh" npm login --registry=http://localhost:8081/repository/AosoFront/ "
  }
  
        
}
     
    
}}