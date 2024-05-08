package utils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

import model.User;

import model.UserData;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.time.Duration;
import java.util.Map;

public class Utils {

    public static void forceWait(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static User getUser(String keyUser) {
        Map<String, Map<String, String>> output ;

        JsonReader getLocalJsonFile;
        try {
            getLocalJsonFile = new JsonReader(new FileReader(Constants.JSON_PATH));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        Type mapTokenType = new TypeToken<Map<String, Map>>() {
        }.getType();

        output= new Gson().fromJson(getLocalJsonFile, mapTokenType);

        return new User(output.keySet().stream().findFirst().orElse(null),
                new UserData(
                             output.get(keyUser).get("user"),
                             output.get(keyUser).get("password"),
                             output.get(keyUser).get("name")
                                ));

    }

    public static Wait waitFor(WebDriver driver){
        return new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(60))
                .pollingEvery(Duration.ofSeconds(3))
                .ignoring(NoSuchElementException.class);
    }


}

