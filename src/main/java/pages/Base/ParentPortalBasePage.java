package pages.Base;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.*;
import org.slf4j.Logger;
import utils.MyLogger;

import static extended.selenium.MobileActions.*;

public class ParentPortalBasePage extends PageBase{

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"< Back\")")
    private WebElement goBackButton;

    static Logger logger = MyLogger.getLogger();

    public ParentPortalBasePage(WebDriver driver) {
        super(driver);
    }

    public void clickBackButton(AndroidDriver driver){
        clickElement(driver, goBackButton);
    }
}
