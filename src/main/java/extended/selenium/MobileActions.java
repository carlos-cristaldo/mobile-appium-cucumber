package extended.selenium;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.SupportsContextSwitching;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.slf4j.Logger;
import utils.MyLogger;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Set;

import static utils.GetProperty.getProperties;

public class MobileActions {

    static Logger logger = MyLogger.getLogger();


    public static Boolean isClickable(WebDriver driver, WebElement element)
    {
        try
        {
            waitFor(driver).until(ExpectedConditions.elementToBeClickable(element));
            return true;
        }
        catch (Exception e)
        {
            return false;
        }
    }

    public static Wait waitFor(WebDriver driver){
        return new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(60))
                .pollingEvery(Duration.ofSeconds(3))
                .ignoring(NoSuchElementException.class);
    }


    public static UiAutomator2Options getOptions() {
        return new UiAutomator2Options()
                .setUdid(getProperties("local.properties", "udid"))
                .setAppPackage("com.k12.onboarding")
                .setAppActivity("com.k12.onboarding.MainActivity")
                .setChromedriverExecutable(getProperties("local.properties", "path_to_chromedriver"))
                ;
    }

    public static void switchContextWebView(AndroidDriver driver){
        logger.info("switching context into WEBVIEW ...");
        Set<String> contextNames = driver.getContextHandles();
        String webContext = new ArrayList<>(contextNames).get(1);
        driver.context(webContext);
    }

    public static void switchContextNativeApp(AndroidDriver driver){
        logger.info("switching context into NATIVE_APP ...");
        Set<String> contextNames = driver.getContextHandles();
        String webContext = new ArrayList<>(contextNames).get(0);
        driver.context(webContext);
    }

    public static void switchContext(AndroidDriver driver){

        logger.info("switching context. Current = {}", driver.getContext());
        String context = driver.getContext();
        Set<String> contextNames = driver.getContextHandles();
        String context0 = new ArrayList<>(contextNames).get(0);
        String context1 = new ArrayList<>(contextNames).get(1);

        assert context != null;
        if (context.equals(context0)){
            driver.context(context1);
        }else {
            driver.context(context0);
        }
        logger.info("Switched to = {}", driver.getContext());
    }
}
