def call (Map config)
{
    node
        {
            stage("gitCheckout") {
            checkout([$class: 'GitSCM', 
            branches: [[name: "${config.brancheName}"]], 
            userRemoteConfigs: [[
                url:"${config.scmurl}"]]
          
        ])
        }  
     }
    
}