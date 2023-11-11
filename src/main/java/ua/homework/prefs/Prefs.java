package ua.homework.prefs;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Prefs {
    public static final String DB_JDBS_CONNECTION_URL = "dbUrl";
    public static final String DEFAULT_PREFS_FILENAME = "prefs.json";
    private Map<String, Objects> prefs = new HashMap<>();

    public Prefs(){
        this(DEFAULT_PREFS_FILENAME);

    }
    public Prefs(String fileneme){
        try {
            String json = String.join( "\n" ,Files.readAllLines(Path.of(fileneme)));
            TypeToken<?> typeToken = TypeToken.getParameterized(
                    Map.class,
                    String.class,
                    Object.class);
            prefs = new Gson().fromJson(json, typeToken.getType());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public String getString(String key){
        return getPref(key).toString();
    }
    public Object getPref(String key){
        return prefs.get(key);
    }
}
