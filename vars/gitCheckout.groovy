def call (Map config)
{
    node
        {
            stage("gitCheckout") {
                sh"echo ${config.branche}"
            checkout([$class: 'GitSCM', 
            branches: [[name: 'refs/heads/main']], 
            userRemoteConfigs: [[
                url:"${config.scmurl}"]]
          
        ])
        }  
     }
    
}