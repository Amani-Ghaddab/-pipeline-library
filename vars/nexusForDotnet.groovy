def call (Map config)
{
    node{
  dir("/srv/Aoso/DevOps/backend/AosoBack") {
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
  
    sh "dotnet nuget push nupkgs/*.nupkg -s http://localhost:8081/repository/AosoBack/ -k f25611e8-6ecc-3587-b95c-6be0ec3248ee"
   
        }  
        
}
     
    
}}