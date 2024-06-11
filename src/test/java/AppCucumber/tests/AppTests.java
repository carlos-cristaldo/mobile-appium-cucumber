package AppCucumber.tests;

import cucumber.api.CucumberOptions;
import extended.selenium.MobileActions;
import io.appium.java_client.android.AndroidStartScreenRecordingOptions;
import model.User;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.InvalidElementStateException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import pages.*;
import pages.Base.PageBase;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.junit.runner.RunWith;
import org.junit.runner.Runner;

import pages.carrousel.*;
import pages.lgcreateaccount.ChooseRolePage;
import pages.lgcreateaccount.CreateLGAccountPage;
import pages.lgcreateaccount.GettingStartedLGPage;
import utils.MyLogger;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Base64;
import java.util.Objects;


import static org.junit.jupiter.api.Assertions.*;
import static utils.Utils.*;

@RunWith(Runner.class)
@CucumberOptions()
public class AppTests extends MobileActions {

    static AndroidDriver driver;
    static PageBase pageBase;
    static LandingPage landingPage;
    static LoginPage loginPage;
    static DashboardPage dashboardPage;
    static ComunityPage comunityPage;
    static WhatWeOfferPage whatWeOfferPage;
    static StudentExperiencePage studentExperiencePage;
    static FindSchoolPage findSchoolPage;
    static HowToStartPage howToStartPage;
    static InformationPage informationPage;
    static ParentPortalPage parentPortalPage;
    static WhoWeArePage whoWeArePage;
    static ChooseRolePage chooseRolePage;
    static GettingStartedLGPage gettingStartedLGPage;
    static CreateLGAccountPage createLGAccountPage;
    static User user;
    static Logger logger = MyLogger.getLogger();

    @Before
    public static void setUp() {

        driver = getDriver();
        driver.startRecordingScreen(
                new AndroidStartScreenRecordingOptions()
                        .withVideoSize("1280x720")
                        .withTimeLimit(Duration.ofSeconds(1800)));

        pageBase = new PageBase(driver);

    }

    @After
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

        //driver.close();
        //driver.terminateApp("com.k12.onboarding");
        driver.quit();


    }

    //-----------------   WHO WE ARE PAGE  -----------------

    public static void whoWeArePageIsOpen() {
        if (Objects.isNull(whoWeArePage)) {
            whoWeArePage = new WhoWeArePage(driver);
        }
        assertTrue(isElementVisible(whoWeArePage.getWhoWeAreLabel()));
    }

    public static void whoWeArePageVideoIsPresent() {
        if (Objects.isNull(whoWeArePage)) {
            whoWeArePage = new WhoWeArePage(driver);
        }
        assertTrue(isElementVisible(whoWeArePage.getVideoElement()));
    }

    public static void whoWeArePageVideoCanBePlayed() {
        if (Objects.isNull(whoWeArePage)) {
            whoWeArePage = new WhoWeArePage(driver);
        }
        clickElement(whoWeArePage.getVideoElement());
        assertTrue(isElementVisible(whoWeArePage.getPlayingVideoElement()));
    }

    public static void whoWeArePageClickRightArrow() {
        if (Objects.isNull(whoWeArePage)) {
            whoWeArePage = new WhoWeArePage(driver);
        }
        //TODO: complete by doing the same w/ other pages
        clickElement(whoWeArePage.getRightArrowButton());
    }

    public static void clickStartSession() {
        if (Objects.isNull(whoWeArePage)) {
            whoWeArePage = new WhoWeArePage(driver);
        }
        clickElement(whoWeArePage.getStartSessionElement());
    }

    //-----------------   WHAT WE OFFER PAGE  -----------------

    public static void whatWeOfferPageIsOpen() {
        if (Objects.isNull(whatWeOfferPage)) {
            whatWeOfferPage = new WhatWeOfferPage(driver);
        }
        System.out.println(whatWeOfferPage.getPageData(driver));
    }

    //-----------------   LOGIN PAGE  -----------------

    public static void loginPageIsOpen() {
        if (Objects.isNull(loginPage)) {
            loginPage = new LoginPage(driver);
        }
        //assertTrue(loginPage.isOpen(driver));
        assertTrue(isElementVisible(loginPage.getChooseAccontType()));
        System.out.println(driver);
    }

    public static void clickLCSelector() {
        if (Objects.isNull(loginPage)) {
            loginPage = new LoginPage(driver);
        }
        loginPage.clickOnLCSelector(driver);
        assertTrue(loginPage.lCIsSelected(driver));
    }

    public static void setUser() {
        if (Objects.isNull(loginPage)) {
            loginPage = new LoginPage(driver);
        }
        loginPage.setInputUsername(user.getUserData().getUser());
    }

    public static void setPass() {
        if (Objects.isNull(loginPage)) {
            loginPage = new LoginPage(driver);
        }
        loginPage.setInputPassword(user.getUserData().getPassword());
    }

    public static void clickLoginButton() {
        if (Objects.isNull(loginPage)) {
            loginPage = new LoginPage(driver);
        }
        loginPage.clickOnLoginButton(driver);
    }


    public static void dismissSecurity() {
        if (Objects.isNull(dashboardPage)) {
            dashboardPage = new DashboardPage(driver);
        }
        dashboardPage.dismissOnSecurity(driver);
    }

    public static void dashboardIsOpen() {
        if (Objects.isNull(dashboardPage)) {
            dashboardPage = new DashboardPage(driver);
        }
        assertTrue(dashboardPage.isOpen(driver, user.getUserData().getName()));
    }

    public static void logout() {
        if (Objects.isNull(dashboardPage)) {
            dashboardPage = new DashboardPage(driver);
        }
        if (Objects.isNull(loginPage)) {
            loginPage = new LoginPage(driver);
        }
        dashboardPage.clickOnMenuButton(driver);
        dashboardPage.clickOnCloseSesionButton();
        assertTrue(loginPage.isOpen(driver));
    }


    public static void selectUser(String data) {
        user = getUser(data);
    }

    public static void clickSignUpButton() {
        if (Objects.isNull(loginPage)) {
            loginPage = new LoginPage(driver);
        }
        if (Objects.isNull(chooseRolePage)) {
            chooseRolePage = new ChooseRolePage(driver);
        }
        loginPage.clickOnSignUpButton(driver);
        assertTrue(isElementVisible(chooseRolePage.getSelectRoleLbl()));
    }

    public static void clickLGAccountSelector() {
        if (Objects.isNull(chooseRolePage)) {
            chooseRolePage = new ChooseRolePage(driver);
        }
        if (Objects.isNull(gettingStartedLGPage)) {
            gettingStartedLGPage = new GettingStartedLGPage(driver);
        }

        scrollDownToElement("ELEGIR CUENTA DE TUTOR");
        clickElement(chooseRolePage.getSelectRoleButton());
        assertTrue(gettingStartedLGPage.isOpen(driver));
    }

    public static void clickCreateLGAccountButton() {
        if (Objects.isNull(gettingStartedLGPage)) {
            gettingStartedLGPage = new GettingStartedLGPage(driver);
        }
        if (Objects.isNull(createLGAccountPage)) {
            createLGAccountPage = new CreateLGAccountPage(driver);
        }
        gettingStartedLGPage.clickOnCreateAccountButton(driver);
        assertTrue(createLGAccountPage.isOpen(driver));
    }

    public static void completeLGCreateAccountForm() {
        if (Objects.isNull(createLGAccountPage)) {
            createLGAccountPage = new CreateLGAccountPage(driver);
        }

        switchForceNativeApp(driver);
        driver.getPageSource();
        try {
            //set first name
            typeOnElement(createLGAccountPage.getFirstNameInput(), generateRandomAlphaString(10));
            //set last name
            typeOnElement(createLGAccountPage.getLastNameInput(), generateRandomAlphaString(10));
            //set email
            typeOnElement(createLGAccountPage.getEmailInput(), generateRandomEmail(10));
            scrollDownToElement("Password");
            //set password
            typeOnElement(createLGAccountPage.getPasswordInput(), generateRandomPass(10));


            //set security questions 1
            //For some unknown reason this element must be clicked twice
            clickElement(createLGAccountPage.getDropboxSecurity1());
            //clickElement(createLGAccountPage.getDropboxSecurity1());
            clickElement(createLGAccountPage.getOption1Selector1());
            typeOnElement(createLGAccountPage.getAnswerSecurityQuestion1(), "pet1");

            //set security questions 2
            clickElement(createLGAccountPage.getDropboxSecurity2());
            clickElement(createLGAccountPage.getOption3Selector2());
            typeOnElement(createLGAccountPage.getAnswerSecurityQuestion2(), "movie1");

            scrollDownToElement("Country");

            //set country
            //clickElement(createLGAccountPage.getCountrySelector());
            clickElement(createLGAccountPage.getStateSelector());
            createLGAccountPage.getStatesList().forEach(e-> System.out.println(e.getText()));

            //TODO: build a method for parameterized this
            WebElement aZState = createLGAccountPage.getStatesList()
                    .stream()
                    .filter(e -> e.getText().equalsIgnoreCase("AZ"))
                    .findFirst()
                    .orElseThrow(IllegalArgumentException::new);

            clickElement(aZState);

        } catch (NoSuchElementException | InvalidElementStateException | StaleElementReferenceException e) {
            logger.error(e.getMessage());
        }
    }

}
