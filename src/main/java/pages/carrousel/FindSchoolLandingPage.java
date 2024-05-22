package pages.carrousel;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.LandingPage;

public class FindSchoolLandingPage extends LandingPage {
    public FindSchoolLandingPage(WebDriver driver) {
        super(driver);
    }

    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.TextView\").instance(7)")
    private WebElement fourthPageIndicator;

    public Boolean fourthPageIndicatorIsEnabled(){
        return fourthPageIndicator.isEnabled();
    }


}
