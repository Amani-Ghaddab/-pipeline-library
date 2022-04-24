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
     stage('location of dockerfile')
                {  
                    sh "docker build -t teeeeeest -f ./mvc/dockerfile ."
                }
    }
    
}