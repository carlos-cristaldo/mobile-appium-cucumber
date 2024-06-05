package extended.selenium;

import io.appium.java_client.*;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.*;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import org.slf4j.Logger;
import utils.Constants;
import utils.MyLogger;

import java.time.Duration;
import java.util.*;

import static java.time.Duration.ofSeconds;
import static org.openqa.selenium.support.ui.ExpectedConditions.*;
import static pages.InformationPage.GRADES_LOCATOR;
import static utils.GetProperty.getProperties;
import static utils.Utils.generateRandomInteger;

public class MobileActions {

    static Logger logger = MyLogger.getLogger();

    public static Boolean isClickable(WebDriver driver, WebElement element) {
        try {
            waitFor(driver).until(ExpectedConditions.elementToBeClickable(element));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static Wait waitFor(WebDriver driver) {
        return new FluentWait<>(driver)
                .withTimeout(ofSeconds(18))
                .pollingEvery(ofSeconds(3))
                .ignoring(NoSuchElementException.class);
    }

    public static Wait waitFor(AndroidDriver driver) {
        return new FluentWait<>(driver)
                .withTimeout(ofSeconds(18))
                .pollingEvery(ofSeconds(3))
                .ignoring(NoSuchElementException.class);
    }

    public static Wait waitFor(WebDriver driver, int sec) {
        return new FluentWait<>(driver)
                .withTimeout(ofSeconds(sec))
                .pollingEvery(ofSeconds(3))
                .ignoring(NoSuchElementException.class);
    }


    public static UiAutomator2Options getOptionsPROD() {
        return new UiAutomator2Options()
                .setUdid(getProperties("local.properties", "udid"))
                .setAppPackage("com.k12.onboarding")
                .setAppActivity("com.k12.onboarding.MainActivity")
                .setChromedriverExecutable(getProperties("local.properties", "path_to_chromedriver"))
                ;
    }

    public static UiAutomator2Options getOptionsQA() {
        return new UiAutomator2Options()
                .setUdid(getProperties("local.properties", "udid"))
               // .setApp("/Users/carloscristaldo/1.21.63-uat.apk")
                .setChromedriverExecutable(getProperties("local.properties", "path_to_chromedriver"))
                ;
    }

    public static void switchContextWebView(AndroidDriver driver) {
        System.out.println(driver.getContextHandles());
        if (!Objects.requireNonNull(driver.getContext()).startsWith("WEBVIEW_")) {
            logger.info("switching context into WEBVIEW ...");
            Set<String> contextNames = driver.getContextHandles();
            String webContext = new ArrayList<>(contextNames).get(1);
            driver.context(webContext);
        }
    }

    public static void switchContextNativeApp(AndroidDriver driver) {
        if (!Objects.requireNonNull(driver.getContext()).equals("NATIVE_APP")) {
            logger.info("switching context into NATIVE_APP ...");
            Set<String> contextNames = driver.getContextHandles();
            String webContext = new ArrayList<>(contextNames).get(0);
            driver.context(webContext);
        }
    }

    public static void switchContext(AndroidDriver driver) {

        logger.info("switching context. Current = {}", driver.getContext());
        String context = driver.getContext();
        Set<String> contextNames = driver.getContextHandles();
        String context0 = new ArrayList<>(contextNames).get(0);
        String context1 = new ArrayList<>(contextNames).get(1);

        assert context != null;
        if (context.equals(context0)) {
            driver.context(context1);
        } else {
            driver.context(context0);
        }
        logger.info("Switched to = {}", driver.getContext());
    }

    public static void hideKeyboard(WebDriver driver) {

        HidesKeyboard hkDriver = (HidesKeyboard) driver;
        hkDriver.hideKeyboard();
    }


    public static void  scrollDown(AndroidDriver driver){

        int startX = driver.manage().window().getSize().getWidth() / 2;
        int startY = driver.manage().window().getSize().getHeight() / 2;

        int endY = (int) (driver.manage().window().getSize().getHeight() * 0.2);

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence scroll = new Sequence(finger, 0);

        scroll.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY));
        scroll.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        scroll.addAction(finger.createPointerMove(Duration.ofMillis(600), PointerInput.Origin.viewport(), startX, endY));
        scroll.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(Collections.singleton(scroll));

    }

    public static WebElement selectRandomGrade(AndroidDriver driver){

        String scriptJs = "return [...document.querySelectorAll('%s')].map(e => %s)";
        String extractorJs = "e.textContent.trim()";

        List<String> elements = (List<String>)  driver.executeScript(String.format(scriptJs, GRADES_LOCATOR, extractorJs));

        return driver.findElement(By.xpath(String.format(Constants.OPTION_GRADE_SELECTOR, elements.get(generateRandomInteger(0, elements.size()-1)))));

    }

    public static void clickOkAlert(AndroidDriver driver){
        String currentContext = driver.getContext();
        switchContextNativeApp(driver);
        driver.findElement(AppiumBy.androidUIAutomator( "new UiSelector().text(\"OK\")")).click();
        driver.context(currentContext);
    }


    public static <T> T waitForPresenceFunction(WebDriver driver, WebElement element) {
        return (T) waitFor(driver).until(visibilityOf(element));
    }

    public static <T> T waitForClickeableFunction(WebDriver driver, WebElement element) {
        return (T) waitFor(driver).until(elementToBeClickable(element));
    }

    public static <T> T clickElement(AndroidDriver driver, WebElement element){
        waitFor(driver).until(elementToBeClickable(element));
        element.click();
        return null;
    }


}
