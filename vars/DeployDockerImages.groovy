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

                 sh "ls -la ${pwd()}/source"

                 sh "ls -la ${pwd()}/source/DevOpsProject/"

                 sh "cd /var/jenkins_home/workspace/ | mkdir aoso"

                 sh "cp -r ${pwd()}/source/DevOpsProject /var/jenkins_home/workspace/aoso"

                 sh "ls -la /var/jenkins_home/workspace/aoso "

            }  
    }
}