package hellocucumber.pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class LandingPage {

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Play Video\")")
    private WebElement videoElement;

    public LandingPage(WebDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(5)), this);
    }

    public Boolean isVideoDisplayed(){
        return videoElement.isDisplayed();
    }
}
