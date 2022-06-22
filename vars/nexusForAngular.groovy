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
    sh" npm --registry=http://localhost:8081/repository/AosoFront publish *.tgz -k a616e0d5-72c9-3de9-8bd7-261ed9452add"
  }
  
        
}
     
    
}}