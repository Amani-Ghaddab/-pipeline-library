def call (Map config)
{
    node{
  dir("Source/AosoFront") {
      sh"ls -a"

  stage('Build') {
  
    sh 'ng build'
 
  }
  stage('Pack') {
  
    sh 'cd dist/AosoFront'
    sh' npm pack'
    
    //sh'npm publish'
    sh" npm login --registry=http://localhost:8081/repository/AosoFront | echo admin | echo 123456"
  }
  
        
}
     
    
}}