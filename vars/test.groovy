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
                //refspec: '+refs/tags/*:refs/remotes/origin/tags/*',
                url:"${config.scmurl}"]]
                //url: 'https://github.com/hediane/teeeeeest.git']]
        ])
    }
    }
}