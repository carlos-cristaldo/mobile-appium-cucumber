package pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utils.Constants;

import java.time.Duration;

public class DashboardPage {

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Lo haré mas tarde\")")
    private WebElement dismissButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\" Comunidad\")")
    private WebElement comunityButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"¿QUIÉNES SOMOS?\")")
    private WebElement whoWeAreLabel;

    public DashboardPage(WebDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(5)), this);
    }

    public void dismissSecurityQuestions(){
        dismissButton.click();
    }

    public void clickOnComunityButton(){
        comunityButton.click();
    }

    public WebElement getDismissButton(){
        return dismissButton;
    }

    public Boolean isOpen(WebDriver driver, String name){
        WebElement welcome = driver.findElement(By.xpath(String.format(Constants.WELCOME_LOCATOR, name)));
        return welcome.isDisplayed();
    }

}
