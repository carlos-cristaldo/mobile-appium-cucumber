package pages.lgcreateaccount;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.Base.ParentPortalBasePage;

import static extended.selenium.MobileActions.*;

@Getter
public class ChooseRolePage extends ParentPortalBasePage {

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"SELECCIONA TU ROL\")")
    private WebElement selectRoleLbl;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"ELEGIR CUENTA DE TUTOR\")")
    private WebElement selectRoleButton;

    public ChooseRolePage(WebDriver driver) {
        super(driver);
    }



}
