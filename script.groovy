void function() {
  writeFile file: 'groovy1.txt', text: env.TARGET_BRANCH
  sh 'ls -l groovy1.txt'
  sh 'cat groovy1.txt'
  final String line = env.TARGET_BRANCH
  echo line
  def text = 'Just saying: "Groovy is gr8!"'
  assert text.takeBetween('is'.toString(), '!'.toString()) == " gr8"
}

return this
