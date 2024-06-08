package pages.lgcreateaccount;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.RemoteWebElement;
import pages.ParentPortalPage;

import java.util.HashMap;
import java.util.List;

import static extended.selenium.MobileActions.*;
import static utils.Utils.*;

public class CreateLGAccountPage extends ParentPortalPage {

    @AndroidFindBy(xpath = "//android.view.View[@text=\"First name\"]")
    private WebElement typeFirstName;

    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.EditText\").instance(1)")
    private WebElement typeLastName;

    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.EditText\").instance(2)")
    private WebElement typeEmail;

    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.EditText\").instance(3)")
    private WebElement typePassword;

    public CreateLGAccountPage(WebDriver driver) {
        super(driver);
    }

    public void inputNamesAndEmail(AndroidDriver driver, String input) {

        System.out.println(driver.getContextHandles());
        switchForceNativeApp(driver);
        driver.getPageSource();
        try {

            waitForPresenceFunction(driver, typeFirstName);
            System.out.println(typeFirstName.isDisplayed());

            /*
            typeFirstName.sendKeys(generateRandomAlphaString(10));
            waitForPresenceFunction(driver,typeLastName);
            typeLastName.sendKeys(generateRandomAlphaString(10));
            waitForPresenceFunction(driver, typeEmail);
            typeEmail.sendKeys(generateRandomEmail(10));
            scrollDownUsingUiScrollable(driver, "Password");
            waitForPresenceFunction(driver,typePassword);
            typePassword.sendKeys(generateRandomAlphaString(10));

new UiSelector().text("Select a question for the security question")
scrollDown(driver);
//android.webkit.WebView[@text="Sign Up"]/android.view.View/android.view.View[2]/android.view.View/android.view.View[2]/android.view.View[2]/android.view.View/android.view.View[2]/android.widget.EditText

            scrollToEndAndFindElements(driver, locator);

            waitForPresencesFunction(driver, elements2);

            tapByCoordinates(driver, 500, 1230);

            scrollDown(driver);
            scrollDown(driver);
            scrollToElement(driver, "android.widget.EditText");
            scrollToEnd(driver);

             */
        }catch (NoSuchElementException | InvalidElementStateException | StaleElementReferenceException e ){
            System.out.println(e.getMessage());
        }
    }

    public void inputPassword(AndroidDriver driver){
        WebElement pass = driver.findElement(By.xpath("//*[@class = 'android.widget.EditText' and (@text = '' or . = '')]"));
        pass.sendKeys(generateRandomAlphaString(10));
    }





}
