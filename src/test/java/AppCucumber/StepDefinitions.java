package AppCucumber;

import io.cucumber.java.en.*;

import static AppCucumber.tests.AppTests.*;
import static utils.Utils.getUser;

public class StepDefinitions {


    @Given("click on login button on the landing page")
    public void theUserIsOnTheLoginPage() {
        clickLoginInLandingPage();
    }



    @Given("user is on the landing page")
    public void userIsOnTheLandingPage() {
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
}
