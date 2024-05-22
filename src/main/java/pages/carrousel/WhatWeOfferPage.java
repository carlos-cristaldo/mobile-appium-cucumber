package pages.carrousel;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.LandingPage;

@Getter
public class WhatWeOfferPage extends LandingPage {

    @FindBy(xpath = "//div[@id=\"what-we-offer\"]/div[2]")
    private WebElement whatWeOfferTxt;

    @FindBy(xpath = "//div[@id=\"what-we-offer\"]/div[4]")
    private WebElement mainText;

    public WhatWeOfferPage(WebDriver driver) {
        super(driver);
    }







}
