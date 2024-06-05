package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import pages.Base.PageBase;
import utils.Constants;

import java.time.Duration;

import static extended.selenium.MobileActions.isClickable;

@Getter
public class LandingPage extends PageBase {


    @FindBy(xpath = "//page-who-we-are/div[1]/iframe")
    private WebElement videoElement;


    @FindBy(xpath = "//page-who-we-are/div[2]")
    private WebElement whoWeAreLabel;

    @FindBy(xpath = "//page-who-we-are/div[4]")
    private WebElement mainText;


    public LandingPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(5)), this);
    }



}
