package fr.deoliveira.jbehave;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;


@Component
public class DemoStep {
    private final static Logger logger = LoggerFactory.getLogger(DemoStep.class);

    @Given("given test")
    public void given() {
        Assert.assertTrue(true);
    }

    @When("when test")
    public void when() {
        Assert.assertTrue(true);
    }

    @Then("then test")
    public void then() {
        Assert.assertTrue(true);
    }
}
