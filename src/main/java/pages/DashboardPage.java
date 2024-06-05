package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import lombok.Getter;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.slf4j.Logger;
import pages.Base.DashboardPageBase;
import utils.Constants;
import utils.MyLogger;

import java.time.Duration;

import static extended.selenium.MobileActions.*;
import static utils.Utils.forceWait;

@Getter
public class DashboardPage extends DashboardPageBase {

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Lo haré mas tarde\")")
    private WebElement doItLater;


    static Logger logger = MyLogger.getLogger();

    public DashboardPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(5)), this);
    }


    public Boolean isOpen(AndroidDriver driver, String name){
        boolean flag = false;
        WebElement welcome;
        String n = "";
        try {
            welcome = (WebElement) waitFor(driver).until(ExpectedConditions.presenceOfElementLocated(By.xpath(String.format(Constants.WELCOME_LOCATOR, name))));
            flag = welcome.isDisplayed();

            n = welcome.getText().substring(5, welcome.getText().length()-1);
            logger.info(STR."User name found = \{ n }");
        }catch (NoSuchElementException e){
            logger.error(e.getMessage());
        }

        return flag && n.equals(name);
    }

    public void dismissOnSecurity(AndroidDriver driver){

        dismissDoItLater(driver);
        //dismissPasswordManager(driver);

    }


    private void dismissPasswordManager(WebDriver driver) {
        /*
        try {
            waitFor(driver, 6).until(ExpectedConditions.visibilityOf(getNoButton()));
            getNoButton().click();
        }catch (TimeoutException | NoSuchElementException e){
            logger.error(e.getMessage());
        }

         */
    }

    private void dismissDoItLater(AndroidDriver driver) {
        try {
            clickElement(driver, doItLater);
        }catch (TimeoutException | NoSuchElementException e){
            logger.error(e.getMessage());
        }
    }

    public void clickReRegButton(WebDriver driver){
        /*
        switchContextWebView((AndroidDriver) driver);
        try {
            waitFor(driver).until(ExpectedConditions.visibilityOf(reRegButton));
            reRegButton.click();
        }catch (NoSuchElementException e){
            logger.error(e.getMessage());
        }
    }

    public void clickEnrollmentButton(WebDriver driver){
        switchContextWebView((AndroidDriver) driver);
        try {
            waitFor(driver).until(ExpectedConditions.visibilityOf(enrollmentButton));
            enrollmentButton.click();
        }catch (NoSuchElementException e){
            logger.error(e.getMessage());
        }*/
    }



}
