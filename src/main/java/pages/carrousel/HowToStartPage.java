package pages.carrousel;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.Base.PageBase;
import utils.Constants;

@Getter
public class HowToStartPage extends PageBase {
    public HowToStartPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@id=\"signup-login\"]/div[2]/div")
    private WebElement signUpLoginTxt;

    @FindBy(xpath = "//lead-form/div/div/div")
    private WebElement mainText;

    @FindBy(xpath = "//div[@id=\"signup-login\"]/div[3]/ion-button[1]")
    private WebElement readyForInscriptionButton;

}
