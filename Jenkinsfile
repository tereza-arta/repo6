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
        VAR = "hello"
    }
    when {
                    expression { VAR == 'hello' }
                
    stages {
        stage('Init') {
            steps {
                script {
                    gv = load "script.groovy"
                }
            }
        }
        stage('Hello') {
            steps {
                echo 'Hello world'
            }
        }
        stage('Check') {
                when {
                    expression { SOURCE_BRANCH == 'staging' }
                }
            steps {
                echo "Merging branch is <staging>"
                script {
                    gv.function()
                    echo "Receiving branch is <dev>"
                }
            }
        }
        stage('Step 1'){
            steps{
                echo "this is step 1"
            }
        }
    }
  }      
}
