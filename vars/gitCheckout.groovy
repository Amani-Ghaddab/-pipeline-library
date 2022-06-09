def call (Map config)
{
    node
        {
            stage("gitCheckout") {
                sh "echo ${config.brancheName}"
            checkout([$class: 'GitSCM', 
            branches: [[name: "${config.brancheName}"]], 
            userRemoteConfigs: [[
                url:"${config.scmurl}"]]
          
        ])
        }  
     }
    
}