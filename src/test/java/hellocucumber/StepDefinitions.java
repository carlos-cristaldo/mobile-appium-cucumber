package hellocucumber;

import io.cucumber.java.en.*;

import static hellocucumber.tests.AppTests.openApp;

public class StepDefinitions {

    @Given("an example scenario")
    public void anExampleScenario() {
        openApp();
    }


}
