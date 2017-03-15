package fr.deoliveira.jbehave;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;
import org.springframework.stereotype.Component;

/**
 * Created by Romain De Oliveira on 15/03/2017.
 */

@Component
public class DemoStep {

    @Given("given test")
    public void given(){
        Assert.assertTrue(true);
    }

    @When("when test")
    public void when(){
        Assert.assertTrue(true);
    }

    @Then("then test")
    public void then(){
        Assert.assertTrue(true);
    }
}
