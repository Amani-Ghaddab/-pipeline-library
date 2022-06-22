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
    sh'npm publish'
  }
  
        
}
     
    
}}