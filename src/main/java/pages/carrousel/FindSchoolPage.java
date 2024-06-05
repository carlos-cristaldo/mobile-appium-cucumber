package pages.carrousel;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.Base.PageBase;
import utils.Constants;

import java.util.List;

@Getter
public class FindSchoolPage extends PageBase {
    public FindSchoolPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@id=\"find-school\"]/div[2]")
    private WebElement findSchoolTxt;

    @FindBy(xpath = "//div[@id=\"find-school\"]/div[4]")
    private WebElement mainText;

    @FindBy(name = "ion-input-0")
    private WebElement inputZipCode;

    @FindBy(xpath = "//div[@id=\"find-school\"]/div[6]/form/ion-button")
    private WebElement searchButton;

   @FindBy(xpath = "//*[contains(@src, 'https://www.k12.com/content/dam/k12/icons/school-finder/logos/')]")
   private List<WebElement> searchResults;


}
