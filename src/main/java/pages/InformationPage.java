package pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.Base.PageBase;
import utils.Constants;

import java.time.Duration;
import java.util.List;

@Getter
public class InformationPage extends PageBase {


    @FindBy(xpath = "//ion-modal[@id=\"ion-overlay-1\"]/lead-form/ion-content/div/div/div")
    private WebElement mainText;

    @FindBy(id = "ion-input-6")
    private WebElement firstNameInput;

    @FindBy(id = "ion-input-7")
    private WebElement lastNameInput;

    @FindBy(id = "ion-input-8")
    private WebElement emailInput;

    @FindBy(id = "ion-input-9")
    private WebElement telInput;

   @FindBy(xpath = "//ion-modal[@id=\"ion-overlay-1\"]//*[@formcontrolname='state']")
   private WebElement stateSelector;

    @FindBy(xpath = "//button[@id=\"alert-input-2-4\"]/div/div[2]")
    private WebElement arizona;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"OK\")")
    private WebElement okButton;

    @AndroidFindBy(className = "android.widget.CheckBox")
    private List<WebElement> checkBox;

    @FindBy(id = "ion-input-10")
    private WebElement postalCodeInput;

    @FindBy(xpath = "//ion-modal[@id=\"ion-overlay-1\"]//*[@formcontrolname='grades']")
    private WebElement cssGradeSelector;

    @FindBy(xpath = "//ion-modal[@id=\"ion-overlay-1\"]//*[@type='submit']")
    private WebElement submitButton;

    @FindBy(xpath = "//page-popup/div")
    private WebElement popupFormSent;

    public static final String GRADES_LOCATOR = "ion-alert div.alert-checkbox-group > button";

    public InformationPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(5)), this);
    }

    public Boolean isOpen(){
        return
                mainText.getText().equals
                        (Constants.TEXT_IN_FIFTH_LANDINGPAGE)
                ;
    }



}
