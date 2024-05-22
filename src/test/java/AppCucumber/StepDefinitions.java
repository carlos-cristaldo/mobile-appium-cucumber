package AppCucumber;

import io.cucumber.java.en.*;
import static AppCucumber.tests.AppTests.*;

public class StepDefinitions {


    @Given("click on login button on the landing page")
    public void theUserIsOnTheLoginPage() {
        clickLoginInLandingPage();
    }


    @Given("user is in landing page")
    public void userIsInLandingPage() {
        landingPageisOpen();
    }


    @When("user enters valid credentials")
    public void theUserEntersValidCredentialsForUser() {
        login();
    }


    @Then("user is in Dashboard Page")
    public void theUserIsInDashboardPage() {
        dashboardPageIsOpen();
    }

    @Given("{string} is selected")
    public void isSelected(String data) {
        setUser(data);
    }

    @When("user goes to dashboard page")
    public void userGoesToDashboardPage() {
        goToDashBoardPage();
    }

    @And("user taps on comunity button")
    public void userTapsOnComunityButton() {
        clickOnComunityButton();
    }

    @And("user clicks on hivebrite button")
    public void userClicksOnHivebriteButton() {
        clickOnHiveBriteButton();
    }


    @And("the carrousel is working")
    public void theCarrouselIsWorking() {
        carrouselTest();
    }

    @When("click on right arrow")
    public void clickOnRightArrow() {
        clickRightArrow();
    }

    @When("user click on login button")
    public void userClickOnLoginButton() {
        clickLoginInLandingPage();
    }

    @And("user clicks on login session button")
    public void userClicksOnLoginSessionButton() {
        clickLoginInLoginPage();
    }

    @Then("user accesses to dashboard page")
    public void userAccessesToDashboardPage() {
        dashboardPageIsOpen();
    }
}
