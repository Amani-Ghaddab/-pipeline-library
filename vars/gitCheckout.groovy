def call (Map config)
{
   pipeline {
      stages{
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
     }
   }
    
}