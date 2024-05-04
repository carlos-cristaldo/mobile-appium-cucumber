package hellocucumber.tests;

import cucumber.api.CucumberOptions;
import hellocucumber.pages.LandingPage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.junit.runner.RunWith;
import org.junit.runner.Runner;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

@RunWith(Runner.class)
@CucumberOptions()
public class AppTests{

    static AndroidDriver driver;
    static LandingPage landingPage;


    @Before
    public void setUp() {
        URL url;

        String appiumServerURL = "http://192.168.1.34:4723/";
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
        landingPage = new LandingPage(driver);
    }

    @After
    public void tearDown(){
        driver.quit();
    }

    public static void openApp(){
        System.out.println("hola");
        System.out.println(landingPage.isVideoDisplayed());
    }


}
