def call(String servicename){
    sh "docker compose up -d --build ${servicename}"
}