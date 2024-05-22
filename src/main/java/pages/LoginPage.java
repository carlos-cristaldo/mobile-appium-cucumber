package pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Constants;

import java.time.Duration;

public class LoginPage {

    @FindBy(xpath = "//h1")
    private WebElement selectAccountType;


    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Iniciar sesión\")")
    private WebElement loginButton;

    @FindBy(id = "loginLCSelector")
    private WebElement lcSelector;

    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.EditText\").instance(0)")
    private WebElement loginEmailLC;

    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.EditText\").instance(1)")
    private WebElement loginPasswordLC;

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(5)), this);
    }

    public Boolean isOpen(){
        return selectAccountType.getText().equals(Constants.SELECT_ACCOUNT_TYPE);
    }

    public void setUsername(String user){
        loginEmailLC.sendKeys(user);
    }

    public void setPassword(String pass){
        loginPasswordLC.sendKeys(pass);
    }

    public void clickOnLoginButton(){
        loginButton.click();
    }

    public void clickLCSelector(){
        lcSelector.click();
    }





}
