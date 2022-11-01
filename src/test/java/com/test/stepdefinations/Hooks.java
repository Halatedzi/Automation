package com.test.stepdefinations;

import com.test.utils.Utils;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks extends Utils {

    @Before
    public void beforeScenario() throws Exception{
        driver = setupWebdriver("chrome");
    }

    @After(order = 0)
    public void AfterSteps(){
        driver.quit();
    }
}
