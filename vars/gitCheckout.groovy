def call (Map config)
{
    node
        {
            stage("gitCheckout") {
                sh"echo ${config.branche}"
            checkout([$class: 'GitSCM', 
            branches: [[name: "${config.branche}"]], 
            userRemoteConfigs: [[
                url:"${config.scmurl}"]]
          
        ])
        // def doesJavaRock = input(message: 'Do you like Java?', ok: 'Yes', 
        //                 parameters: [booleanParam(defaultValue: true, 
        //                 description: 'If you like Java, just push the button',name: 'Yes?')])

        //     echo "Java rocks?:" + doesJavaRock
        }
        stage('test') {
    
              sh 'whoami'
              sh'touch amani'
              sh 'ls'
            
            }
    try {
        stage('Test') {
            sh 'echo "Fail!"; exit 1'
        }
        
    } catch (e) {
        echo 'This will run only if failed'

        // Since we're catching the exception in order to report on it,
        // we need to re-throw it, to ensure that the build is marked as failed
        throw e
    } finally {
        def currentResult = currentBuild.result ?: 'SUCCESS'
        if (currentResult == 'UNSTABLE') {
            echo 'This will run only if the run was marked as unstable'
        }

        def previousResult = currentBuild.getPreviousBuild()?.result
        if (previousResult != null && previousResult != currentResult) {
            echo 'This will run only if the state of the Pipeline has changed'
            echo 'For example, if the Pipeline was previously failing but is now successful'
        }

        echo 'This will always run'
    }  
     }
    
}