pipeline{
    agent any
    environment { 
        SOURCE_BRANCH = sh(
                    script: "git log --merges --first-parent origin/main | awk '/Merge pull request/{split(\$NF, arr, \"/\"); print arr[2]}' | head -1",
                    returnStdout: true
                ).trim()
        TARGET_BRANCH = sh(
                    script: "git log --merges --first-parent origin/main | awk '/Merge pull request/{split(\$NF, arr, \"/\"); print arr[1]}' | head -1",
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
                echo 'source branch is $SOURCE_BRANCH'
                            
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
    }
}
