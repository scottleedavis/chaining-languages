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
