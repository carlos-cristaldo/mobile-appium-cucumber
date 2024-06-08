package pages.lgcreateaccount;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.Base.ParentPortalBasePage;

import static extended.selenium.MobileActions.clickElement;
import static extended.selenium.MobileActions.waitForPresenceFunction;

public class GettingStartedLGPage extends ParentPortalBasePage {

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"¡Excelente! Sigue adelante.\")")
    private WebElement greatKeepGoingLbl;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"TUTOR LEGAL\")")
    private WebElement LGLbl;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"CREA UNA CUENTA\")")
    private WebElement createAccountButton;

    public GettingStartedLGPage(WebDriver driver) {
        super(driver);
    }

    public Boolean isOpen(AndroidDriver driver){
        waitForPresenceFunction(driver, greatKeepGoingLbl);
        waitForPresenceFunction(driver, LGLbl);

        return greatKeepGoingLbl.isDisplayed() && LGLbl.isDisplayed();
    }

    public void clickOnCreateAccountButton(AndroidDriver driver){
        clickElement(driver, createAccountButton);
    }
}
