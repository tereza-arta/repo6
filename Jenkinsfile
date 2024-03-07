pipeline{
    agent any
    environment { 
        SOURCE_BRANCH = sh(
                    script: "git log --merges --first-parent origin/main | awk '/Merge pull request/{split(\$NF, arr, \"/\"); print arr[2]}' | head -1",
                    returnStdout: true
                ).trim()
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
                    expression { SOURCE_BRANCH == 'staging' }
                }
            steps {
                echo 'Yes, source branch is staging'
                            
            }
        }
        stage('Get Merged Branch Name') {
            steps {
                script {
                    // Run git command to get the name of the merged branch
                    def mergedBranchName = sh(script: 'git rev-parse --abbrev-ref HEAD', returnStdout: true).trim()
                    
                    // Print the name of the merged branch
                    echo "Merged branch name: $mergedBranchName"
                }
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
