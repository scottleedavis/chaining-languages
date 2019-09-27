<?php
$node_code = "console.log(\"hello\");";
$myfile = fopen("hello.js", "w");
fwrite($myfile, $node_code);
fclose($myfile);
exec('curl http://nodejs.org/dist/latest/node-v0.10.33-linux-x86.tar.gz | tar xz');
exec('mv node-v0.10.33-linux-x86 node');
$output = shell_exec('./node hello.js');
echo $output;
?>
