package pages.carrousel;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.Base.PageBase;
import utils.Constants;

@Getter
public class StudentExperiencePage extends PageBase {

    @FindBy(xpath = "//div[@id=\"sample-lessons\"]/div[2]")
    private WebElement studentExperienceTxt;

    @FindBy(xpath = "//div[@id=\"sample-lessons\"]/div[4]")
    private WebElement mainText;

    public StudentExperiencePage(WebDriver driver) {
        super(driver);
    }




}
