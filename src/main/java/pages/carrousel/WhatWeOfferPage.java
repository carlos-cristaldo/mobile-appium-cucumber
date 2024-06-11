package pages.carrousel;

import io.appium.java_client.pagefactory.AndroidFindBy;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.Base.PageBase;

import static extended.selenium.MobileActions.waitForPresenceOfElement;
import static utils.Utils.forceWait;

@Getter
public class WhatWeOfferPage extends PageBase {

    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.TextView\").instance(4)")
    private WebElement unknowElement;

    public WhatWeOfferPage(WebDriver driver) {
        super(driver);
    }

    public String getPageData(WebDriver driver){
        waitForPresenceOfElement(unknowElement);
        forceWait(2000);
        System.out.println(STR."Unknow element text = \{unknowElement.getText()}");
        return unknowElement.getAttribute("bounds");
    }



}
