def call(String credId,String imageName){
    withCredentials([usernamePassword(
                        credentailsId:"${credId}",
                        usernameVariable:"dockerHubUser",
                        passwordVariable:"dockerHubPass"
        )]){
        
        sh "docker login -u ${env.dockerHubUser} -p ${env.dockerHubPass}"
        sh "docker image tag ${imageName} ${env.dockerHubUser}/two-tier-flask-app"
        sh "docker push ${env.dockerHubUser}/${imageName}:latest"
    }
    
}
