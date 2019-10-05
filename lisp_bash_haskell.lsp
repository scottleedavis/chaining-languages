;gnu clisp 2.49

(ext:shell "echo \"-module(m).
-compile(export_all).

hello() ->
  io:format(\"Hello World~n\").\" > module_name.erl")
(ext:shell "echo \"c(m). module_name:hello().\" | erl")
