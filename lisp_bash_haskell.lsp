;gnu clisp 2.49

(ext:shell "echo \"-module(m).
-compile(export_all).

hello() ->
  io:format(\"Hello World~n\").\" > m.erl")
(ext:shell "echo \"c(m). m:hello().\" | erl")
