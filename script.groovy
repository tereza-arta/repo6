void function() {
  writeFile file: 'groovy.txt', text: env.TARGET_BRANCH
  sh 'ls -l groovy.txt'
  sh 'cat groovy.txt'
  def line = env.TARGET_BRANCH
  echo line
}

return this
