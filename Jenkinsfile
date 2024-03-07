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
        stage('Get Merged and Merging Branches') {
            steps {
                script {
                    // Run git command to get the name of the currently checked-out branch
                    def currentBranch = sh(script: 'git rev-parse --abbrev-ref HEAD', returnStdout: true).trim()

                    // Run git command to get the names of merged branches
                    def mergedBranches = sh(script: 'git branch --merged', returnStdout: true).trim()

                    // Run git command to get the names of branches that are merging
                    def mergingBranches = sh(script: 'git branch --no-merged', returnStdout: true).trim()

                    // Split the output by newline character
                    def mergedBranchList = mergedBranches.tokenize('\n')
                    def mergingBranchList = mergingBranches.tokenize('\n')

                    // Print the name of the currently checked-out branch
                    echo "Current branch: $currentBranch"

                    // Print the names of merged branches
                    echo "Merged branches:"
                    for (String branch in mergedBranchList) {
                        echo "- $branch"
                    }

                    // Print the names of branches that are merging
                    echo "Merging branches:"
                    for (String branch in mergingBranchList) {
                        echo "- $branch"
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
