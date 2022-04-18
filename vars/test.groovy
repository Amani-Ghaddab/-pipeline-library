def call(scmurl) { 

    node { 
       // agent any
        stage('Checkout') { 
            
            echo "Checking out the sources..."
            git branch: 'main',
            Checkout "${scmurl}"
        //    git url: "git@github.com:jenkinsci/${scmurl}"
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