pipeline{
    agent any
    environment { 
        CC = 'clang'
    }
    stages {
        stage('Hello') {
            steps {
                echo 'Hello world'
                echo 'Hello from me'
            }
        }
        stage('Check') {
                when {
                    expression { CC == 'clang' }
                }
            steps {
                echo 'Yes, CC is clang'
            }
        }
 /*    stage('Checkout') {
            steps {
                SOURCE_BRANCH = sh(
                    script: "git log --merges --first-parent origin/main | awk '/Merge pull request/{split(\$NF, arr, \"/\"); print arr[2]}' | head -1",
                    returnStdout: true
                ).trim()
                when {
                    expression { SOURCE_BRANCH == "staging" }
                }
                
            }
        } */
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
