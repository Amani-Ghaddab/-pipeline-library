def call (Map config)
{
  
           stage('Clean') {
   steps {
    sh 'dotnet clean'
   }
  }
  stage('Build') {
   steps {
    sh 'dotnet build --configuration Release'
   }
  }
  stage('Pack') {
   steps {
    sh 'dotnet pack --no-build --output nupkgs'
   }
  }
  stage('Publish') {
   steps {
    sh "dotnet nuget push **\\nupkgs\\*.nupkg -k 9de1620e-126d-325b-af11-acba7a14b436 -s http://localhost:8081/repository/Backpackaging/"
   }
        }  
        
}
     
    
