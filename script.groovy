def function() {
  echo "Target branch is ${env.TARGET_BRANCH}" > file.txt
  sh 'ls'
}

return this
