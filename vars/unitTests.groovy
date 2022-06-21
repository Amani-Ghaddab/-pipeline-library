stage('Test: Unit Test'){
   steps {
     sh "dotnet test YourProjectPath/UnitTest_DevOpsProject.csproj"
     }
  }
       
 stage('Test: Integration Test'){
    steps {
       sh "dotnet test ProjectPath/IntegrateTest_DevOpsProject.csproj"
      }
   }