pipeline{
    agent any
    stages {
        stage('Hello') {
            steps {
                echo 'Hello world'
                echo 'Hello from me'
            }
        }
        stage('Checkout') {
            steps {
                script {
                    checkout scmGit(branches: [[name: '*/dev']], extensions: [[$class: 'PreBuildMerge', options: [mergeRemote: 'repo6', mergeTarget: 'dev']]], userRemoteConfigs: [[url: 'https://github.com/tereza-arta/repo6.git']])
                }
            }
        }
        stage('Step 1'){
            when {
                expression { return params.current_status == "closed" && params.merged == true && params.branch == "dev" }
            }
            steps{
                echo "this is step 1"
            }
        }
        stage('Step 2'){
            when {
                expression { return params.current_status == "closed" && params.merged == true && params.branch == "dev" }
            }
            steps{
                echo "this is step 2"
            }
        }
    }
}
