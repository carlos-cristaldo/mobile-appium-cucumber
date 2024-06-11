package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.Base.ParentPortalBasePage;

import static extended.selenium.MobileActions.waitForPresenceOfElement;


@Getter
public class ParentPortalPage extends ParentPortalBasePage {

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"K12 Logo\")")
    private WebElement k12HomeLogo;

    public ParentPortalPage(WebDriver driver) {
        super(driver);
    }

    public Boolean isOpen(AndroidDriver driver){
        waitForPresenceOfElement( k12HomeLogo);
        return k12HomeLogo.isDisplayed();
    }

}
