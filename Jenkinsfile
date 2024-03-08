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
    }
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
                echo 'Hello from me'
            }
        }
        stage('Check') {
                when {
                    expression { SOURCE_BRANCH == 'staging' }
                }
            steps {
                echo 'Yes, source branch is staging'
                script {
                    /* writeFile file: 'groovy1.txt', text: env.TARGET_BRANCH
                    sh 'ls -l groovy1.txt'
                    sh 'cat groovy1.txt'
                    final String line = env.TARGET_BRANCH
                    echo line
                    def text = 'Just saying: "Groovy is gr8!"'
                    assert text.takeBetween('is', '!') == ' gr8' */
                    gv.function()
                }
                /*sh '''#!/bin/bash
                        echo "${env.TARGET_BRANCH}"
                '''
                */
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
