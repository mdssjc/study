package com.github.mdssjc.script;

import javax.script.Bindings;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 * Hands-on sobre a Script API.
 * 
 * @author Marcelo dos Santos
 *
 */
public class Main {

  public static void main(final String[] args) {
    final ScriptEngineManager factory = new ScriptEngineManager();
    final ScriptEngine engine = factory.getEngineByName("Nashorn");

    final Bindings bindings = engine.createBindings();
    bindings.put("str", "Calling JavaScript");
    bindings.put("engine", engine);

    try {
      engine.eval("print(str + ' from ' + engine.getClass().getSimpleName())",
          bindings);
    } catch (final ScriptException e) {
      System.err.println(e.getMessage());
    }
  }
}
