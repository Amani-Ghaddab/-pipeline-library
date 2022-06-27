def call (Map config)
{
    node{
  dir("srv/Aoso/DevOps/backend") {
      sh"ls -a"
stage('Clean') {
   
    sh 'dotnet clean'
  
  }
  stage('Build') {
  
    sh 'dotnet build --configuration Release'
    sh"ls -a"
 
  }
  stage('Pack') {
  
    sh 'dotnet pack --no-build --output nupkgs'
  }
  stage('Publish') {
  
    sh "dotnet nuget push nupkgs/*.nupkg -s http://localhost:8081/repository/AosoBack/ -k a616e0d5-72c9-3de9-8bd7-261ed9452add"
   
        }  
        
}
     
    
}}