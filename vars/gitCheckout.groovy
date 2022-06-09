def call (Map config)
{
    node
        {
            stage("gitCheckout") {
                sh"echo ${config.branche}"
            checkout([$class: 'GitSCM', 
            branches: [[name: ${config.branche}]], 
            userRemoteConfigs: [[
                url:"${config.scmurl}"]]
          
        ])
        }  
     }
    
}