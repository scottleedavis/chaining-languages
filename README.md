# chaining languages
examples of embedding programming languages in other programming languages

### go -> perl -> bash
```go
package main

import (
    "fmt"
    "strings"

    "github.com/bradfitz/campher/perl"
)

func main() {
    p := perl.NewInterpreter()
    p.Eval("my $result = `/bin/bash echo \"hello\"`;")
    fmt.Println("result is:", p.EvalString("$result"))
}
```

### java -> python -> lua
```java
import org.python.util.PythonInterpreter;

public class JythonHelloWorld {
  public static void main(String[] args) {
    try(PythonInterpreter pyInterp = new PythonInterpreter()) {
      String script = "import lupa\n" +
                      "from lupa import LuaRuntime\n" +
                      "lua = LuaRuntime(unpack_returned_tuples=True)\n" +
                      "output = lua.eval('1+1')";
      pyInterp.exec(script);
      PyInteger output = (PyInteger)pyInterp.get("output");
      System.out.println("output = " + output.getValue());
    }
  }
}
```

### php -> bash -> nodejs
```php
<?php
$node_code = "console.log(\"hello\");";
$myfile = fopen("hello.js, "w");
fwrite($myfile, $node_code);
fclose($myfile);
exec('curl http://nodejs.org/dist/latest/node-v0.10.33-linux-x86.tar.gz | tar xz');
exec('mv node-v0.10.33-linux-x86 node');
$output = shell_exec('./node hello.js');
echo $output;
?>
```

### scala -> javascript
```scala
import javax.script.ScriptEngineManager

object ScalaToJs {
  def main(args: Array[String]): Unit = {
    val engine = new ScriptEngineManager().getEngineByMimeType("text/javascript")
    val result = engine.eval("1 + 1")
    println(result)
  }
}
```

### ruby -> bash -> nodejs -> python
```ruby
r = IO.popen("echo \"#{[
  "let {PythonShell} = require('python-shell')",
  "PythonShell.runString('print(\\\"hello\\\")', null, function (_, results) {",
      "console.log(results);",
  "});",
].join("\n")}\" > hello.js; node hello.js", "r+")
puts r.read
```

### c# -> nodejs -> cobol
```csharp
using System;
using System.Threading.Tasks;
using EdgeJs;

class Program
{
    public static async Task Start()
    {
        var func = Edge.Func(@"
            const Cobol = require("cobol");

            return function (data, callback) {
				Cobol(function () {/*
				                    	IDENTIFICATION DIVISION.
							PROGRAM-ID. HELLO-WORLD.
							PROCEDURE DIVISION.
							DISPLAY 'Hello, world'.
							STOP RUN.
				                   */}, {
				                       compileargs:{
				                           free: true
				                       }
				                   }, function (err, data) {
               		callback(null, err || data);
				});
            }
        ");

        Console.WriteLine(await func());
    }

    static void Main(string[] args)
    {
        Start().Wait();
    }
}
```

### pascal -> bash -> nodejs -> lisp
```pascal
program project1;

{$mode objfpc}{$H+}

uses 
  Process;

var 
  s : ansistring;

begin

if RunCommand('/usr/local/bin/node',['-e','const lisp = require(\'lisp\');console.log(lisp(\'(+ "hello" " world"\'));'],s) then
   writeln(s); 

end.
```
