package AppCucumber.tests;

import cucumber.api.CucumberOptions;
import io.appium.java_client.android.AndroidStartScreenRecordingOptions;
import io.appium.java_client.android.options.UiAutomator2Options;
import model.User;
import org.apache.commons.io.FileUtils;
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
import static org.junit.jupiter.api.Assertions.*;
import static utils.GetProperty.getProperties;
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
    static FindSchoolPage findSchoolPage;
    static HowToStartPage howToStartPage;
    static InformationPage informationPage;
    static ParentPortalPage parentPortalPage;
    static WhoWeArePage whoWeArePage;
    static ChooseRolePage chooseRolePage;
    static User user;
    static Logger logger = MyLogger.getLogger();

    @Before
    public static void setUp() {

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

        pageBase = new PageBase(driver);
        /*
        landingPage = new LandingPage(driver);
        loginPage = new LoginPage(driver);
        dashboardPage = new DashboardPage(driver);
        comunityPage = new ComunityPage(driver);
        whatWeOfferPage = new WhatWeOfferPage(driver);
        studentExperiencePage = new StudentExperiencePage(driver);
        findSchoolPage = new FindSchoolPage(driver);
        howToStartPage = new HowToStartPage(driver);
        informationPage = new InformationPage(driver);
        reRegPage = new ReRegPage(driver);

         */
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

        driver.quit();

    }

    //-----------------   WHO WE ARE PAGE  -----------------

    public static void whoWeArePageIsOpen(){
        if (Objects.isNull(whoWeArePage)){
            whoWeArePage = new WhoWeArePage(driver);
        }
        assertTrue(whoWeArePage.isOpen(driver));
    }

    public static void whoWeArePageVideoIsPresent(){
        if (Objects.isNull(whoWeArePage)){
            whoWeArePage = new WhoWeArePage(driver);
        }
        assertTrue(whoWeArePage.videoElementIsPresent(driver));
    }

    public static void whoWeArePageVideoCanBePlayed(){
        if (Objects.isNull(whoWeArePage)){
            whoWeArePage = new WhoWeArePage(driver);
        }
        assertTrue(whoWeArePage.videoCanBePlayed(driver));
    }

    public static void whoWeArePageClickRightArrow(){
        if (Objects.isNull(whoWeArePage)){
            whoWeArePage = new WhoWeArePage(driver);
        }
        whoWeArePage.clicRightArrow(driver);
    }

    public static void whatWeOfferPageIsOpen(){
        if (Objects.isNull(whatWeOfferPage)){
            whatWeOfferPage = new WhatWeOfferPage(driver);
        }
        System.out.println(whatWeOfferPage.getPageData(driver));
    }

    public static void clickStartSession(){
        if (Objects.isNull(whoWeArePage)){
            whoWeArePage = new WhoWeArePage(driver);
        }
        whoWeArePage.clickOnStartSession(driver);
    }

    public static void loginPageIsOpen(){
        if (Objects.isNull(loginPage)){
            loginPage = new LoginPage(driver);
        }
        assertTrue(loginPage.isOpen(driver));
    }

    public static void clickLCSelector(){
        if (Objects.isNull(loginPage)){
            loginPage = new LoginPage(driver);
        }
        loginPage.clickOnLCSelector(driver);
        assertTrue(loginPage.lCIsSelected(driver));
    }

    public static void setUser(){
        if (Objects.isNull(loginPage)){
            loginPage = new LoginPage(driver);
        }
        loginPage.setInputUsername(user.getUserData().getUser());
    }

    public static void setPass(){
        if (Objects.isNull(loginPage)){
            loginPage = new LoginPage(driver);
        }
        loginPage.setInputPassword(user.getUserData().getPassword());
    }

    public static void clickLoginButton(){
        if (Objects.isNull(loginPage)){
            loginPage = new LoginPage(driver);
        }
        loginPage.clickOnLoginButton(driver);
    }


    public static void dismissSecurity(){
        if (Objects.isNull(dashboardPage)){
            dashboardPage = new DashboardPage(driver);
        }
        dashboardPage.dismissOnSecurity(driver);
    }

    public static void dashboardIsOpen(){
        if (Objects.isNull(dashboardPage)){
            dashboardPage = new DashboardPage(driver);
        }
        assertTrue(dashboardPage.isOpen(driver,user.getUserData().getName()));
    }


    public static void selectUser(String data){
        user = getUser(data);
    }

    public static void clickSignUpButton(){
        if (Objects.isNull(loginPage)){
            loginPage = new LoginPage(driver);
        }
        if (Objects.isNull(chooseRolePage)){
            chooseRolePage = new ChooseRolePage(driver);
        }
        loginPage.clickOnSignUpButton(driver);
        assertTrue(chooseRolePage.isOpen(driver));
    }

    public static void clickLGAccountSelector(){
        if (Objects.isNull(chooseRolePage)){
            chooseRolePage = new ChooseRolePage(driver);
        }
        chooseRolePage.clickOnLGAccountSelector(driver);
    }



}
