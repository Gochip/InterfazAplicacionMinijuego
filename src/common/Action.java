package common;

import executors.response.MessageResponse;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Parisi Germán
 */
public class Action {

    private final String name;
    private HashMap<String, String> values;
    private static String FIRST_SEPARATOR = ":.";
    private static String SECOND_SEPARATOR = ",,";
    private static String THIRD_SEPARATOR = "=";

    public Action(String name) {
        this.name = name;
        this.values = new HashMap<>();
    }

    public void addValue(String key, String value) {
        this.values.put(key, value);
    }

    public String getValue(String v){
        return this.values.get(v);
    }
    
    public HashMap<String, String> getValues(){
        return values;
    }

    public String getName(){
        return this.name;
    }

    public static Action getAction(MessageResponse response) {
        String t = response.getText();
        String parts[] = t.split(FIRST_SEPARATOR);
        Action action;
        if (parts.length == 2) {
            String name = parts[0];
            String code = parts[1];
            action = new Action(name);
            String keysValues[] = code.split(SECOND_SEPARATOR);
            for (String kv : keysValues) {
                if (!kv.trim().equals("")) {
                    String partskv[] = kv.split(THIRD_SEPARATOR);
                    if (partskv.length == 2) {
                        String key = partskv[0];
                        String value = partskv[1];
                        action.addValue(key, value);
                    } else {
                        throw new RuntimeException("Action mal formado: " + t);
                    }
                }
            }
        } else {
            throw new RuntimeException("Action mal formado: " + t);
        }

        return action;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(name).append(FIRST_SEPARATOR);
        for (Map.Entry<String, String> e : values.entrySet()) {
            sb.append(e.getKey()).append(THIRD_SEPARATOR).append(e.getValue()).append(SECOND_SEPARATOR);
        }
        return sb.toString();
    }
}
