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
    //sh"ng build --aot --prod"
    //sh'npm publish'
    sh" npm --registry=http://localhost:8081/repository/AosoFrontProxy/
   // | echo admin | echo 123456 | amani.ghaddab@eniso.u-sousse.tn"
  }
  
        
}
     
    
}}