package com.test;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features={ "src/test/resources/featureFiles"},
        tags = {"googleSearch"},
        plugin = {"pretty",
                  "json:target/cucumber/cucumber.json",
                  "junit:target/cucumber/cucumber.xml"},
        monochrome = true
)
public class Runner {

}
