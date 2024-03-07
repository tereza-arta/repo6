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
        stage('Get Merged Branches') {
            steps {
                script {
                    // Run git command to get merged branches
                    def mergedBranches = sh(script: 'git branch --merged', returnStdout: true).trim()
                    
                    // Split the output by newline character
                    def mergedBranchList = mergedBranches.tokenize('\n')
                    
                    // Iterate through each branch name
                    for (String branch in mergedBranchList) {
                        // Perform actions with each merged branch name
                        echo "Merged branch: $branch"
                    }
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
