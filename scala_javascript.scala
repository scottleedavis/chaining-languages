import javax.script.ScriptEngineManager

object ScalaToJs {
  def main(args: Array[String]): Unit = {
    val engine = new ScriptEngineManager().getEngineByMimeType("text/javascript")
    val result = engine.eval("1 + 1")
    println(result)
  }
}
