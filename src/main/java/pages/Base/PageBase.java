package pages.Base;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Constants;

import java.time.Duration;

@Getter
public class PageBase {

    @FindBy(xpath = "//ion-toolbar/ion-buttons[2]/ion-button")
    protected WebElement loginButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"MÁS INFORMACIÓN\")")
    private WebElement moreInfoElement;

    @FindBy(xpath = "//steps-bar/ion-button[2]")
    private WebElement rightArrowButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.Button\").instance(3)")
    private WebElement leftArrowButton;


    public PageBase(WebDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(5)), this);
    }

    public WebElement footerDot(WebDriver driver, String pos){
        return driver.findElement(By.xpath(String.format(Constants.FOOTER_DOTS, pos)));
    }


}
