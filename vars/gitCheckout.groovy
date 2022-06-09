def call (Map config)
{
    node
        {
            stage("gitCheckout") {
            checkout([$class: "${config.GitSCM}", 
            branches: [[name: brancheName]], 
            userRemoteConfigs: [[
                url:"${config.scmurl}"]]
          
        ])
        }  
     }
    
}