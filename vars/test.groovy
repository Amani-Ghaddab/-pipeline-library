def call(name) { 

    pipeline { 
       // agent any
        stage('Checkout') { 
            
            echo "Checking out the sources...${name}"
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