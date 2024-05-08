package pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class LoginPage {

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Elija el Tipo de Cuenta\")")
    private WebElement selectAccountType;

    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.TextView\").instance(4)")
    private WebElement accountTypeSelector;

    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.EditText\").instance(0)")
    private WebElement username;

    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.EditText\").instance(1)")
    private WebElement password;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Iniciar sesión\")")
    private WebElement loginButton;




    public LoginPage(WebDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(5)), this);
    }

    public Boolean isOpen(){
        return selectAccountType.isDisplayed();
    }

    public void clickAccountTypeSelector(){
        accountTypeSelector.click();
    }

    public void setUsername(String user){
        username.sendKeys(user);
    }

    public void setPassword(String pass){
        password.sendKeys(pass);
    }

    public void clickOnLoginButton(){
        loginButton.click();
    }





}
