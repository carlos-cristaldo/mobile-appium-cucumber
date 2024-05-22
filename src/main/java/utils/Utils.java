package utils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

import model.User;

import model.UserData;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.Map;

import static utils.GetProperty.getProperties;

public class Utils {

    public static void forceWait(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static User getUser(String keyUser) {
        Map<String, UserData> output ;
        JsonReader getLocalJsonFile;
        try {
            getLocalJsonFile = new JsonReader(new FileReader(Constants.JSON_PATH));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        Type mapTokenType = new TypeToken<Map<String, UserData>>() {
        }.getType();

        output= new Gson().fromJson(getLocalJsonFile, mapTokenType);

        return new User(keyUser,
              output.get(keyUser));
    }


}

