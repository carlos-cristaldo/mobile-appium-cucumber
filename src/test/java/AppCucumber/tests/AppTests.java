package AppCucumber.tests;

import cucumber.api.CucumberOptions;
import io.appium.java_client.android.AndroidStartScreenRecordingOptions;
import model.User;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import pages.Base.PageBase;
import pages.ComunityPage;
import pages.DashboardPage;
import pages.LandingPage;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.junit.runner.RunWith;
import org.junit.runner.Runner;

import pages.LoginPage;
import pages.carrousel.StudentExperiencePage;
import pages.carrousel.WhatWeOfferPage;
import utils.Constants;
import utils.MyLogger;

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
import java.util.Objects;


import static extended.selenium.MobileActions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static utils.Utils.*;

@RunWith(Runner.class)
@CucumberOptions()
public class AppTests {

    static AndroidDriver driver;
    static PageBase pageBase;
    static LandingPage landingPage;
    static LoginPage loginPage;
    static DashboardPage dashboardPage;
    static ComunityPage comunityPage;
    static WhatWeOfferPage whatWeOfferPage;
    static StudentExperiencePage studentExperiencePage;
    static User user;
    static Logger logger = MyLogger.getLogger();

    @Before
    public void setUp() {

        URL url;
        try {
            url = new URI(Constants.APPIUM_SERVER_URL).toURL();
        } catch (MalformedURLException | URISyntaxException e) {
            throw new RuntimeException(e);
        }

        driver = new AndroidDriver(
                url, getOptions()
        );

        logger.info(driver.toString());

        driver.startRecordingScreen(
                new AndroidStartScreenRecordingOptions()
                        .withVideoSize("1280x720")
                        .withTimeLimit(Duration.ofSeconds(1800)));

        pageBase = new PageBase(driver);
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

        forceWait(5000);
        driver.quit();

    }

    public static void landingPageisOpen() {
        landingPage = new LandingPage(driver);
        switchContext(driver);
        assertTrue(landingPage.isOpen());
        assertTrue(landingPage.isVideoDisplayed());
        assertEquals(
                landingPage.getVideoElement().getAttribute("src"),
                Constants.VIDEO_SOURCE);
        assertTrue(isClickable(driver, landingPage.getVideoElement()));
        assertEquals(
                landingPage.getMainText().getText(),
                Constants.TEXT_IN_FIRST_LANDINGPAGE);
    }

    public static void clickLoginInLandingPage() {
        landingPage.clickOnLoginButton();
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
        forceWait(2000);
    }

    public static void carrouselTest() {

        switchContextWebView(driver);
        whatWeOfferPage = new WhatWeOfferPage(driver);
        studentExperiencePage = new StudentExperiencePage(driver);
        assertEquals(
                whatWeOfferPage.getWhatWeOfferTxt().getText(),
                Constants.WHAT_WE_OFFER);

        assertEquals(
                whatWeOfferPage.footerDot(driver,"2").getAttribute("class"),
                Constants.STEP_ACTIVE_CLASS);

        assertEquals(
                whatWeOfferPage.getMainText().getText(),
                Constants.TEXT_IN_SECOND_LANDINGPAGE);

        clickRightArrow();

        assertTrue(studentExperiencePage.isOpen(driver));

        /*
        assertEquals(
                studentExperiencePage.getStudentExperienceTxt().getText(),
                Constants.STUDENT_EXPERIENCE);

        assertEquals(
                studentExperiencePage.footerDot(driver,"3").getAttribute("class"),
                Constants.STEP_ACTIVE_CLASS);

        assertEquals(
                studentExperiencePage.getMainText().getText(),
                Constants.TEXT_IN_THIRD_LANDINGPAGE);

         */

        clickRightArrow();


    }

    public static void clickRightArrow(){
        if (!Objects.requireNonNull(driver.getContext()).startsWith("WEBVIEW_")) {
            switchContextWebView(driver);
        }
        pageBase.getRightArrowButton().click();

    }

    public static void login() {

        loginPage = new LoginPage(driver);
        assertTrue(loginPage.isOpen());
        loginPage.clickLCSelector();
        if (!Objects.requireNonNull(driver.getContext()).equals("NATIVE_APP")) {
            switchContextNativeApp(driver);
        }
        loginPage.setUsername(user.getUserData().getUser());
        loginPage.setPassword(user.getUserData().getPassword());

    }

    public static void dashboardPageIsOpen() {
        dashboardPage = new DashboardPage(driver);
        waitFor(driver).until(ExpectedConditions.visibilityOf(dashboardPage.getDismissButton()));
        dashboardPage.dismissSecurityQuestions();
        assertTrue(dashboardPage.isOpen(driver, user.getUserData().getName()));

    }

    public static void goToDashBoardPage() {
        login();
    }


    public static void setUser(String data) {
        user = getUser(data);
    }


}
