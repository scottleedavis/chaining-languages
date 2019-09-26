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
