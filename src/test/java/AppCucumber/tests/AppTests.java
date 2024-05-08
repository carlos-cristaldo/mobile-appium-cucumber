package AppCucumber.tests;

import cucumber.api.CucumberOptions;
import model.User;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import pages.ComunityPage;
import pages.DashboardPage;
import pages.LandingPage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidStartScreenRecordingOptions;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.junit.runner.RunWith;
import org.junit.runner.Runner;

import java.io.File;

import org.apache.commons.io.FileUtils;
import pages.LoginPage;
import utils.MyLogger;

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


import static org.junit.jupiter.api.Assertions.assertTrue;
import static utils.Utils.*;

@RunWith(Runner.class)
@CucumberOptions()
public class AppTests {

    static AndroidDriver driver;
    static LandingPage landingPage;
    static LoginPage loginPage;
    static DashboardPage dashboardPage;
    static ComunityPage comunityPage;
    static User user;
    static Logger logger = MyLogger.getLogger();


    @Before
    public void setUp() {
        URL url;

        String appiumServerURL = "http://192.168.1.21:4723/";
        try {
            url = new URI(appiumServerURL).toURL();
        } catch (MalformedURLException | URISyntaxException e) {
            throw new RuntimeException(e);
        }

        UiAutomator2Options options = new UiAutomator2Options()
                .setUdid("R5CW40AWA1F")
                .setAppPackage("com.k12.onboarding")
                .setAppActivity("com.k12.onboarding.MainActivity");
        driver = new AndroidDriver(
                url, options
        );

        driver.startRecordingScreen(
                new AndroidStartScreenRecordingOptions()
                        .withVideoSize("1280x720")
                        .withTimeLimit(Duration.ofSeconds(200)));
        landingPage = new LandingPage(driver);
    }

    @After
    public void tearDown() {

        Timestamp stamp = Timestamp.valueOf(LocalDateTime.now());
        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        String timestamp = formatter.format(stamp.toLocalDateTime())
                .replace(":", "-")
                .replace(".", "-");
        String path = String.format("evidence/video/%s.mp4", timestamp);

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

    public static void landingPageisOpen() {

        assertTrue(landingPage.isVideoDisplayed());
        /*
        try {
            DriveFileManager.conectionDriveTest();
        } catch (IOException | GeneralSecurityException e) {
            throw new RuntimeException(e);
        }

         */

    }

    public static LoginPage clickLoginInLandingPage() {
        landingPage.clickOnLoginButton();
        assertTrue(landingPage.isOpen());
        return new LoginPage(driver);


    }

    public static DashboardPage clickLoginInLoginPage() {
        loginPage.clickOnLoginButton();
        return new DashboardPage(driver);

    }

    public static ComunityPage clickOnComunityButton() {
        dashboardPage.clickOnComunityButton();
        forceWait(5000);
        return new ComunityPage(driver);
    }

    public static void clickOnHiveBriteButton(){
        comunityPage = clickOnComunityButton();
        comunityPage.clickOnHiveBriteButton();
        forceWait(7000);
    }

    //new UiSelector().text("< Back")


    public static void login() {

        loginPage = clickLoginInLandingPage();
        assertTrue(loginPage.isOpen());
        loginPage.clickAccountTypeSelector();
        loginPage.setUsername(user.getUserData().getUser());
        loginPage.setPassword(user.getUserData().getPassword());
        dashboardPage = clickLoginInLoginPage();
        waitFor(driver).until(ExpectedConditions.visibilityOf(dashboardPage.getDismissButton()));
        logger.info("dismiss button in displayed = {}", dashboardPage.getDismissButton().isDisplayed());
        dashboardPage.dismissSecurityQuestions();

        forceWait(3000);

    }

    public static void dashboardPageIsOpen() {
        assertTrue(dashboardPage.isOpen(driver, user.getUserData().getName()));
    }

    public static void goToDashBoardPage() {
        login();
    }


    public static void setUser(String data) {
        user = getUser(data);
    }


}
