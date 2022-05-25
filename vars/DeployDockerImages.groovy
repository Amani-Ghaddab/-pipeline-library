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

                sh "if [ ! -d $~${config.destinationFile} ]
                    then
                        mkdir -p ~${config.destinationFile}"
                    else
                       echo "Directory exists"
                    fi
               
              //  sh "cp -r ${pwd()} ~${config.destinationFile}"
                // | mkdir ${pwd()}/${config.projectName}/DevOps | ${pwd()}/${config.projectName} 
                //sh "mkdir /var/jenkins_home/workspace/aoso/ | mkdir /var/jenkins_home/workspace/aoso/DevOps | mkdir /var/jenkins_home/workspace/aoso/DevOps/backend "
               //  sh "cp -r ${pwd()}/Source/DevOpsProject ${pwd()}/${config.projectName}/"
                

                 //sh "cd mkdir aoso"


            }  
    }
}