def call(Map config) { 
  
    pipeline { 
        stage('Checkout') { 
            echo "Checking out the sources...${config.name}"
           
            //checkout scmurl
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