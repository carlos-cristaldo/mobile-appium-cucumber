package pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import pages.Base.DashboardPageBase;
import utils.Constants;

import java.time.Duration;

@Getter
public class DashboardPage extends DashboardPageBase {

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Lo haré mas tarde\")")
    private WebElement dismissButton;

    public DashboardPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(5)), this);
    }

    public void dismissSecurityQuestions(){
        dismissButton.click();
    }

    public Boolean isOpen(WebDriver driver, String name){
        WebElement welcome = driver.findElement(By.xpath(String.format(Constants.WELCOME_LOCATOR, name)));
        return welcome.isDisplayed();
    }

}
