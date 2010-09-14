import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
 
public class Eval {
    public static void main(String[] args) {
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("js");
        
        try {
            String expression = "(3+4+3)/2*2+4";
            Object result = engine.eval(expression);
            System.out.println(expression+" = "+result);
        } catch(ScriptException se) {
            se.printStackTrace();
        }
    }
}