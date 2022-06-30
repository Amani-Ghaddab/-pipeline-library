def call (Map config)
{
    node
        {
      
        stage ('create the local project directory')
            {   
                sh " mkdir -p ${config.destinationFolder} "
                sh " cp -r Source/${config.projectName} ${config.destinationFolder}"
                sh " cp -r ${config.dockerComposeFileLocation} ${config.dockerFileLocation} ${config.nginxLocation} ${config.destinationFolder}"
                sh " ls -la ${config.destinationFolder} "
                dir ("/srv/Aoso/DevOps/backend"){
                dockerImage = docker.build "docker_back/front" + ":latest" }
            }  
        stage('push image in nexus'){      
                                //def version = "latest"
                                //sh 'docker build -f "${config.Dockerfile}" -t nexus_docker/aoso '
                                docker.withRegistry( 'http://localhost:8082/repository/dockerForBack', 'dockerForBack' ) { 
                                    dockerImage.push() 
                                } 
                             }
     }
}
