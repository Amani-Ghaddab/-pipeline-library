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
                 sh "cp -r ${pwd()}/source/DevOpsProject /var/jenkins_home/workspace/aoso/DevOps/backend"
                 

                 //sh "cd mkdir aoso"


            }  
    }
}