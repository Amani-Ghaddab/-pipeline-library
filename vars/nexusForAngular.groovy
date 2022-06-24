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
    sh"npm config set registry http://localhost:8081/"
    //sh'npm publish'
    sh" npm login --registry=http://localhost:8081/repository/AosoFrontProxy/"
   // | echo admin | echo 123456 | amani.ghaddab@eniso.u-sousse.tn"
  }
  
        
}
     
    
}}