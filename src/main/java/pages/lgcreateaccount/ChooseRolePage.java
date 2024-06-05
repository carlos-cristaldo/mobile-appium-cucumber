package pages.lgcreateaccount;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.Base.ParentPortalBasePage;

import static extended.selenium.MobileActions.*;

public class ChooseRolePage extends ParentPortalBasePage {

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"SELECCIONA TU ROL\")")
    private WebElement selectRoleLbl;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"ELEGIR CUENTA DE TUTOR\")")
    private WebElement selectRoleButton;

    public ChooseRolePage(WebDriver driver) {
        super(driver);
    }

    public Boolean isOpen(AndroidDriver driver) {
        waitForPresenceFunction(driver, selectRoleLbl);
        return selectRoleLbl.isDisplayed();
    }

    public void clickOnLGAccountSelector(AndroidDriver driver) {
        scrollDown(driver);
        clickElement(driver, selectRoleButton);
    }

}
