package pages.carrousel;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.Base.PageBase;

import static extended.selenium.MobileActions.*;


@Getter
public class WhoWeArePage extends PageBase {

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"¿QUIÉNES SOMOS?\")")
    private WebElement whoWeAreLabel;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"EFAO 30s App\").instance(2)")
    private WebElement playingVideoElement;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Play Video\")")
    private WebElement videoElement;

    public WhoWeArePage(WebDriver driver) {
        super(driver);
    }






}
