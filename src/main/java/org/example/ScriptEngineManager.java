package org.example;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineFactory;
import javax.script.ScriptException;
import static java.lang.System.*;

public class ScriptEngineManager {
    public static void main(String[] args) {
        if (args.length != 1) {
            err.println("uso: java RunJSScript scriptEnJS");
            return;
        }

        javax.script.ScriptEngineManager manager = new javax.script.ScriptEngineManager(); // Inicio el API de Scripting

        List<ScriptEngineFactory> lista = manager.getEngineFactories();

        for (ScriptEngineFactory f : lista){
            out.println("Nombre: " + f.getEngineName());
            out.println("Version: " + f.getEngineVersion());
            out.println("Engine short names: " + f.getNames());
        }

        ScriptEngine engine = manager.getEngineByName("ECMAScript");

        try {
            engine.eval(new FileReader(args[0])); // Sí, los flujos con importantes
        } catch (ScriptException | IOException se) {
            err.println(se.getMessage());
        }
    }
}