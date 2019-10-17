let {PythonShell} = require('python-shell')

console.log(1)

const foo = `import os
print(2);
import subprocess

batcmd="perl -e 'print 3;'"
result = subprocess.check_output(batcmd, shell=True)
print(result)
`
PythonShell.runString(foo, null, function (err, results) {
  if (err) console.log(err)
  console.log('finished', results);
});
