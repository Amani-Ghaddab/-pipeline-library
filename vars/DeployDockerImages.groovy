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

                sh "ls -la ${pwd()}"
                sh "cd .."
                sh "echo ${config.destinationFile} ${config.projectName}" 
                sh " ${pwd()}"
                sh "mkdir ${config.destinationFile}"
                // | mkdir ${pwd()}/${config.projectName}/DevOps | ${pwd()}/${config.projectName} 
                //sh "mkdir /var/jenkins_home/workspace/aoso/ | mkdir /var/jenkins_home/workspace/aoso/DevOps | mkdir /var/jenkins_home/workspace/aoso/DevOps/backend "
               //  sh "cp -r ${pwd()}/Source/DevOpsProject ${pwd()}/${config.projectName}/"
                

                 //sh "cd mkdir aoso"


            }  
    }
}