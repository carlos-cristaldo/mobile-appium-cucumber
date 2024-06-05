package utils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidStartScreenRecordingOptions;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.Timestamp;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Base64;

import static extended.selenium.MobileActions.getOptionsPROD;
import static extended.selenium.MobileActions.getOptionsQA;
import static utils.GetProperty.getProperties;
import static utils.Utils.forceWait;

public class ConfigurationLoader {

    static AndroidDriver driver;
    static Logger logger = MyLogger.getLogger();

    public static AndroidDriver setUp() {

        UiAutomator2Options options;
        URL url;
        try {
            url = new URI(getProperties("local.properties", "appium_server_url")).toURL();
        } catch (MalformedURLException | URISyntaxException e) {
            throw new RuntimeException(e);
        }

        if (getProperties("local.properties", "ENV").equals("QA")) {

            options = getOptionsQA();
        } else {
            options = getOptionsPROD();
        }

        driver = new AndroidDriver(
                url, options
        );


        logger.info(driver.toString());

        driver.startRecordingScreen(
                new AndroidStartScreenRecordingOptions()
                        .withVideoSize("1280x720")
                        .withTimeLimit(Duration.ofSeconds(1800)));

        return driver;
    }

    public static void tearDown() {

        Timestamp stamp = Timestamp.valueOf(LocalDateTime.now());
        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        String timestamp = formatter.format(stamp.toLocalDateTime())
                .replace(":", "-")
                .replace(".", "-");
        String path = String.format("evidence/video/%s.mp4", timestamp);
        forceWait(3000);
        String video = driver.stopRecordingScreen();
        byte[] decode = Base64.getDecoder().decode(video);

        try {
            FileUtils.writeByteArrayToFile(new File(path), decode);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        /*
        try {

            DriveFileManager.uploadBasic(path);
        } catch (IOException | GeneralSecurityException e) {
            throw new RuntimeException(e);
        }

         */

        driver.quit();

    }
}
