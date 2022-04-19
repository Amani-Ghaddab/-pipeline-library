def call(scmurl) { 

    node { 
        stage('Clone sources') {
           echo "Checking out the sources..."
           // git url:'https://github.com/Amani-Ghaddab/docker-jenkins-.git'
            ["git", "clone", "https://github.com/Amani-Ghaddab/docker-jenkins-.git", "*/main"].execute()
          }
        }
 
        /*stage('Build Image') {
                    sh 'docker build -t ${config.imageName}'
        }
        stage('Integration Test') {
		     steps {
                    sh ' docker-compose -f ${config.dockerCompose} up '
              
           	 }
         }*/
    }
}