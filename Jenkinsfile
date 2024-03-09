def gv

pipeline{
    agent any
    environment { 
        SOURCE_BRANCH = sh(
                    script: "git log --merges --first-parent origin/main | awk '/Merge pull request/{split(\$NF, arr, \"/\"); print arr[2]}' | head -1",
                    returnStdout: true
                ).trim()
        TARGET_BRANCH = sh(
                    script: "git log --merges --first-parent origin/main | tail -n 1",
                    returnStdout: true
                ).trim() 
        SHOULD_RUN = 'true'
    }
    stages {
        stage('Init') {
            steps {
                script {
                    if (env.SHOULD_RUN == 'true') {
                        gv = load "script.groovy"
                        echo "from init stage"
                    }
                }
            }
        }
        stage('Check') {
            when {
                    expression { SOURCE_BRANCH == 'staging' }
            }
            steps {
                echo env.BRANCH_NAME
                echo "Merging branch is <staging>"
                script {
                    gv.function()
                    echo "Receiving branch is <dev>"
                }
            }
        }
        stage('Build') {
            steps {
                echo "Building the ptoject..."
            }
        }
        stage('Test') {
            steps {
                echo "Testing the ptoject..."
            }
        }
        stage('Deploy') {
            steps {
                echo "Deploying the ptoject..."
            }
        }
    }
}
