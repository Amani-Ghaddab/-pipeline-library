def call (Map config)
{
    node
        {
           stage("gitCheckout") {
            checkout([$class: 'GitSCM', 
            branches: [[name: 'refs/heads/main']], 
            userRemoteConfigs: [[
                url:"${config.scmurl}"]]
        ])
        }
        stage ('move all file')

            {    
               
                sh " mkdir -p ~${config.destinationFile}/Sources "
                sh "cp -r ${config.dockerComposeLocation} ~${config.destinationFile}"
                sh "cp -r ${config.dockerComposeLocation} ${config.dockerFileLocation} ${config.nginxLocation} ~${config.destinationFile}"
                sh " tree ~${config.destinationFile}"
                // | mkdir ${pwd()}/${config.projectName}/DevOps | ${pwd()}/${config.projectName} 
                //sh "mkdir /var/jenkins_home/workspace/aoso/ | mkdir /var/jenkins_home/workspace/aoso/DevOps | mkdir /var/jenkins_home/workspace/aoso/DevOps/backend "
               //  sh "cp -r ${pwd()}/Source/DevOpsProject ${pwd()}/${config.projectName}/"
                

                 //sh "cd mkdir aoso"


            }  
    }
}