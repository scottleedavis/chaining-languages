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

