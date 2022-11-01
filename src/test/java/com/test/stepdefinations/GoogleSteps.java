package com.test.stepdefinations;

import com.test.utils.Utils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GoogleSteps extends Utils {

    @Given("the user has launched the browser")
    public void the_user_has_launched_the_browser() {

        String baseURL = getConfigPropertyValue("./Framework.properties","site");
        driver.manage().window().maximize();
        driver.get(baseURL);

    }

    @When("the user searches {string}")
    public void the_user_searches(String string) {

    }

    @Then("the user should see results page")
    public void the_user_should_see_results_page() {

    }

}
