package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.Base.PageBase;
import utils.Constants;

import java.time.Duration;

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

    public Boolean isVideoDisplayed(){
        return videoElement.isDisplayed();
    }

    public Boolean isOpen(){
        return whoWeAreLabel.isDisplayed();
    }

    public void clickOnLoginButton(){
        super.loginButton.click();
    }

    public WebElement getMainText(WebDriver driver, String txt){
        txt = txt.substring(0,10);
        String locator =  String.format("//android.widget.TextView[contains(@text, '%s')]", txt);
        return driver.findElement(AppiumBy.xpath(locator));

    }




}
