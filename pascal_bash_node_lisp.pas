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
