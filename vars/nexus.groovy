def call (Map config)
{
    node{
  dir("Source/AosoBack") {
      sh"ls -a"
stage('Clean') {
   
    sh 'dotnet clean'
  
  }
  stage('Build') {
  
    sh 'dotnet build --configuration Release'
 
  }
  stage('Pack') {
  
    sh 'dotnet pack --no-build --output nupkgs'
  }
  stage('Publish') {
  
    sh "dotnet nuget push nupkgs/*.nupkg -k 9de1620e-126d-325b-af11-acba7a14b436 -s http://localhost:8081/repository/Backpackaging/"
   
        }  
        
}
     
    
}}