import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

class Main {
  public static void main(String[] args) {
        String[] aCmdArgs = { "perl", "-e"
                  , "use Inline 'Lua' => 'function print_lua (a) print(a) end'; print_lua(\"Hello World.\")" };
        Runtime oRuntime = Runtime.getRuntime();
        Process oProcess = null;

        try {
            oProcess = oRuntime.exec(aCmdArgs);
            oProcess.waitFor();
        } catch (Exception e) {
            System.out.println("error executing " + aCmdArgs[0]);
        }

        try {
          /* dump output stream */
          BufferedReader is = new BufferedReader
              ( new InputStreamReader(oProcess.getInputStream()));
          String sLine;
          while ((sLine = is.readLine()) != null) {
              System.out.println(sLine);
          }
        } catch (IOException e) {}
        System.out.flush();

        /* print final result of process */
        System.err.println("Exit status=" + oProcess.exitValue());
        return;  }
}
