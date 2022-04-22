def call (Map config)
{
    node
        {
            stage('msg')
            {
                echo "checking out the source scmurl "
                echo "${config.scmurl}"
            }
           stage("testCheckout") {
            checkout([$class: 'GitSCM', 
            branches: [[name: 'refs/heads/main']], 
            userRemoteConfigs: [[
                url:"${config.scmurl}"]]

        ])
    }  
    stage('location of dockerfile'){
                {  
                    sh "docker build -t teeeeeest -f ./mvc/dockerfile ."
                    echo "checking out the source dockerfile "
                }
    }
    }
}