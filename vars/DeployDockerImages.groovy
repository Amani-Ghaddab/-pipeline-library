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
                 sh "mkdir ${config.projectName}/Source | mkdir ${config.projectName}"
                 

                 //sh "cd mkdir aoso"


            }  
    }
}