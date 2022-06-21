def call (Map config)
{
    node
        {
           stage('Approval Step'){
          steps{
                
                //----------------send an approval prompt-------------
                script {
                   env.APPROVED_DEPLOY = input message: 'User input required',
                   parameters: [choice(name: 'Deploy?', choices: 'no\nyes', description: 'Choose "yes" if you want to deploy this build')]
                       }
                //-----------------end approval prompt------------
            }
           }
        // def doesJavaRock = input(message: 'Do you like Java?', ok: 'Yes', 
        //                 parameters: [booleanParam(defaultValue: true, 
        //                 description: 'If you like Java, just push the button',name: 'Yes?')])

        //     echo "Java rocks?:" + doesJavaRock
        }  
     }
    
}