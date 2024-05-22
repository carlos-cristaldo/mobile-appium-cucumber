package pages.carrousel;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.LandingPage;
import utils.Constants;

import static org.testng.AssertJUnit.assertEquals;

@Getter
public class StudentExperiencePage extends LandingPage {

    @FindBy(xpath = "//div[@id=\"sample-lessons\"]/div[2]")
    private WebElement studentExperienceTxt;

    @FindBy(xpath = "//div[@id=\"sample-lessons\"]/div[4]")
    private WebElement mainText;

    public StudentExperiencePage(WebDriver driver) {
        super(driver);
    }

    public Boolean isOpen(WebDriver driver){
        return
                getStudentExperienceTxt().getText().equals
                        (Constants.STUDENT_EXPERIENCE)
                &&
                footerDot(driver,"3").getAttribute("class").equals
                        (Constants.STEP_ACTIVE_CLASS)
                &&
                getMainText().getText().equals
                        (Constants.TEXT_IN_THIRD_LANDINGPAGE);
    }



}
