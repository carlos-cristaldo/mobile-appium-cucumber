package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.Base.ParentPortalBasePage;

import static extended.selenium.MobileActions.clickElement;
import static extended.selenium.MobileActions.waitForPresenceFunction;

public class LoginPage extends ParentPortalBasePage {

  @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.TextView\").instance(4)")
  private WebElement lCSelector;

  @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Elija el Tipo de Cuenta\")")
  private WebElement chooseAccontType;

  @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Soy el Mentor de mis estudiantes.\")")
  private WebElement lCLbl;

  @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.EditText\").instance(0)")
  private WebElement inputUsername;

  @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.EditText\").instance(1)")
  private WebElement inputPassword;

  @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Iniciar sesión\")")
  private WebElement loginButton;

  @AndroidFindBy(uiAutomator = "new UiSelector().text(\"¿Aún no tienes una cuenta?\")")
  private WebElement signUpButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }


    public void clickOnLCSelector(AndroidDriver driver){
        clickElement(driver, lCSelector);
    }

    public Boolean isOpen(AndroidDriver driver){
        waitForPresenceFunction(driver, chooseAccontType);
        return chooseAccontType.isDisplayed();
    }

    public Boolean lCIsSelected(AndroidDriver driver){
        waitForPresenceFunction(driver, lCLbl);
        return lCLbl.isDisplayed();
    }

    public void setInputUsername(String user){
        inputUsername.sendKeys(user);
    }
    public void setInputPassword(String pass){
        inputPassword.sendKeys(pass);
    }

    public void clickOnLoginButton(AndroidDriver driver){
        clickElement(driver, loginButton);
    }

    public void clickOnSignUpButton(AndroidDriver driver){
        clickElement(driver, signUpButton);
    }
}
