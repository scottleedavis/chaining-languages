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
