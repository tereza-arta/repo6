pipeline{
    agent any
    stages {
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
