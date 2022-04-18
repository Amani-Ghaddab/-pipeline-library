def call(scmurl) { 
  
    pipeline { 
      //  agent any
        stage('Checkout') { 
            echo "Checking out the sources..."
           
            heckout scmurl
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