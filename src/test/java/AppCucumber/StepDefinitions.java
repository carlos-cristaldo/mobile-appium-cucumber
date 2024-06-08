package AppCucumber;

import io.cucumber.java.en.*;

import static AppCucumber.tests.AppTests.*;


public class StepDefinitions {


    @Given("click on loginLC button on the landing page")
    public void theUserIsOnTheLoginPage() {

    }


    @Given("user is in who we are page")
    public void userIsInLandingPage() {
        whoWeArePageIsOpen();
    }


    @When("user enters valid credentials")
    public void theUserEntersValidCredentialsForUser() {

    }


    @Then("user is in Dashboard Page")
    public void theUserIsInDashboardPage() {

    }

    @Given("{string} is selected")
    public void isSelected(String data) {
        selectUser(data);
    }

    @When("user goes to dashboard page")
    public void userGoesToDashboardPage() {

    }

    @And("user taps on comunity button")
    public void userTapsOnComunityButton() {

    }

    @And("user clicks on hivebrite button")
    public void userClicksOnHivebriteButton() {

    }


    @And("the carrousel is working")
    public void theCarrouselIsWorking() {

    }

    @When("click on right arrow")
    public void clickOnRightArrow() {
        whoWeArePageClickRightArrow();
    }

    @When("user click on loginLC button")
    public void userClickOnLoginButton() {
        ;
    }

    @And("user clicks on loginLC session button")
    public void userClicksOnLoginSessionButton() {
    }

    @Then("user is redirected to dashboard page")
    public void userAccessesToDashboardPage() {
        dashboardIsOpen();
    }

    @When("click on information icon")
    public void clickOnInformationIconInPage() {

    }

    @Then("sign up or sign in can be performed")
    public void signUpOrSignInCanBePerformed() {
    }

    @Given("user in in Find Your School Page")
    public void userInInFindYourSchoolPage() {

    }


    @When("login as an LC")
    public void loginAsAnLC() {

        clickStartSession();
        loginPageIsOpen();
        clickLCSelector();
        setUser();
        setPass();
        clickLoginButton();
        dismissSecurity();

    }


    @When("login as an LG")
    public void loginAsAnLG() {

        clickStartSession();
        loginPageIsOpen();
        setUser();
        setPass();
        clickLoginButton();
        dismissSecurity();
    }

    @And("click on re-reg button")
    public void clickOnReRegButton() {

    }

    @Then("parent portal page is open")
    public void reRegPageIsOpened() {

    }

    @When("click on back button in new PP Page")
    public void clickOnBackButtonInNewPPPage() {

    }

    @When("going to How to Start Page")
    public void goingToHowToStartPage() {

    }

    @And("click on ready for inscription button")
    public void clickOnReadyForInscriptionButton() {

    }

    @When("click on enrollment button")
    public void clickOnEnrollmentButton() {

    }

    @Then("video is present")
    public void videoIsPresent() {
        whoWeArePageVideoIsPresent();
    }

    @And("video can be played")
    public void videoCanBePlayed() {
        whoWeArePageVideoCanBePlayed();
    }

    @Then("user is in what we offer page")
    public void userIsInWhatWeOfferPage() {
        whatWeOfferPageIsOpen();
    }

    @When("navigate to login page")
    public void navigateToLoginPage() {
        clickStartSession();
        loginPageIsOpen();
    }

    @And("click sign up link")
    public void clickOnSignUpLink() {
        clickSignUpButton();
    }

    @And("select LG Role")
    public void selectLGRole() {
        clickLGAccountSelector();
    }

    @And("and click on create account button")
    public void completeTheSignUpProcess() {
        clickCreateLGAccountButton();
    }

    @And("completes the registration process")
    public void completesTheRegistrationProcess() {
        completeLGCreateAccountForm();
    }

    @And("user is logged out of the app")
    public void userIsLoggedOutOfTheApp() {
        logout();
    }
}
