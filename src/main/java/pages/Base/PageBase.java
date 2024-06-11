package pages.Base;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

import static extended.selenium.MobileActions.clickElement;

@Getter
public class PageBase {

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"MÁS INFORMACIÓN\")")
    private WebElement moreInfoElement;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"INICIAR SESIÓN\")")
    private WebElement startSessionElement;

    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.Button\").instance(4)")
    private WebElement rightArrowButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.TextView\").instance(7)")
    private WebElement footerDotElement;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"background-content\")")
    private WebElement backgroundContent;



    public PageBase(WebDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(5)), this);
    }

    public void clickOnStartSession(AndroidDriver driver){
        clickElement(startSessionElement);
    }

}
