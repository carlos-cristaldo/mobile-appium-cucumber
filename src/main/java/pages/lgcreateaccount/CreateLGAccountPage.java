package pages.lgcreateaccount;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import lombok.Getter;
import org.openqa.selenium.*;
import pages.ParentPortalPage;

import java.util.List;

import static extended.selenium.MobileActions.*;
import static utils.Utils.*;

@Getter
public class CreateLGAccountPage extends ParentPortalPage {

    //input text
    @AndroidFindBy(xpath = "//android.view.View[@text=\"First name\"]/following-sibling::android.view.View/android.widget.EditText")
    private WebElement firstNameInput;

    @AndroidFindBy(xpath = "//android.view.View[@text=\"Last name\"]/following-sibling::android.view.View/android.widget.EditText")
    private WebElement lastNameInput;

    @AndroidFindBy(xpath = "//android.view.View[@text=\"Email Address\"]/following-sibling::android.view.View/android.widget.EditText")
    private WebElement emailInput;

    @AndroidFindBy(xpath = "//android.view.View[@text=\"Password\"]/following-sibling::android.view.View/android.widget.EditText")
    private WebElement passwordInput;


    //security questions
    @AndroidFindBy(xpath = "//android.view.View[@text=\"Answer security question 1\"]/following-sibling::android.view.View/android.widget.EditText")
    private WebElement answerSecurityQuestion1;

    @AndroidFindBy(xpath = "//android.view.View[@text=\"Answer security question 2\"]/following-sibling::android.view.View/android.widget.EditText")
    private WebElement answerSecurityQuestion2;


    //Selectors dropdown
    @AndroidFindBy(xpath = "//android.view.View[@text=\"Please add a security question 1\"]/following::android.view.View/android.widget.Spinner[@text=\"Select a question for the security question\"]")
    private WebElement dropboxSecurity1;

    @AndroidFindBy(xpath = "//android.view.View[@text=\"Please add a security question 2\"]/following::android.view.View/android.widget.Spinner[@text=\"Select a question for the security question\"]")
    private WebElement dropboxSecurity2;


    //set options
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"What is the name of your favorite pet?\")")
    private WebElement option1Selector1;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"What is the name of your favorite movie?\")")
    private WebElement option3Selector2;

    @AndroidFindBy(xpath = "//android.widget.Spinner[@text=\"UNITED STATES OF AMERICA\"]")
    private WebElement countrySelector;

    @AndroidFindBy(xpath = "//android.widget.Spinner[@text=\"Select State\"]")
    private WebElement stateSelector;

    @AndroidFindBy(xpath = "//android.view.View[@text=\"AZ\"]")
    private WebElement stateOption;

    @AndroidFindBy(xpath = "//android.widget.ListView[@text=\"State\"]/child::android.view.View/android.widget.TextView")
    List<WebElement> statesList;




    public CreateLGAccountPage(WebDriver driver) {
        super(driver);
    }

}
