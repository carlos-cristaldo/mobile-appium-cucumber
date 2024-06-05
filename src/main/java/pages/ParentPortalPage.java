package pages;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.Base.ParentPortalBasePage;


@Getter
public class ParentPortalPage extends ParentPortalBasePage {

    @FindBy(className = "student-card__header__title")
    private WebElement k12HomeIcon;

    public ParentPortalPage(WebDriver driver) {
        super(driver);
    }

    public Boolean isOpen(){
        return k12HomeIcon.isDisplayed();
    }

}
