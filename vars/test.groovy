def call (Map config)
{
    Pipeline{
    stages{
        stage("test")
            steps{
                gitCheckout('https://github.com/Amani-Ghaddab/ProjectDevops.git')
            }
    }
}
     
}
