r = IO.popen("echo \"#{[
	"let {PythonShell} = require('python-shell')",
 	"PythonShell.runString('print(\\\"hello\\\")', null, function (_, results) {",
  		"console.log(results);",
	"});",
].join("\n")}\" > hello.js; node hello.js", "r+")
puts r.read