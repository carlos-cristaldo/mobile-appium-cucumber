package pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class ComunityPage {

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Hivebrite\")")
    private WebElement hiveBriteButton;



    public ComunityPage(WebDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(5)), this);
    }

    public void clickOnHiveBriteButton(){
        System.out.println(hiveBriteButton.isDisplayed());
        hiveBriteButton.click();
    }




}
