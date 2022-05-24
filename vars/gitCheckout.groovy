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
     }
    
}