package me.nanigans.pandorapunishments;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JsonUtils {

    private static final PandoraPunishments plugin = PandoraPunishments.getPlugin(PandoraPunishments.class);

    public static File jsonPath = new File(plugin.getDataFolder() + "/Punishments.json");


    public static Object getData(String path) throws IOException, ParseException {

        String[] paths = path.split("\\.");
        JSONParser jsonParser = new JSONParser();
        Object parsed = jsonParser.parse(new FileReader(jsonPath));
        JSONObject jsonObject = (JSONObject) parsed;

        JSONObject currObject = (JSONObject) jsonObject.clone();

        for (String s : paths) {

            if(currObject.get(s) instanceof JSONObject)
            currObject = (JSONObject) currObject.get(s);
            else return currObject.get(s);

        }

        return currObject;

    }

    public static List<?> fromString(String string) {
        String[] strings = string.replace("[", "").replace("]", "").split(", ");
        Object[] result = new Object[strings.length];
        System.arraycopy(strings, 0, result, 0, result.length);
        return new ArrayList(Arrays.asList(result));
    }

}
