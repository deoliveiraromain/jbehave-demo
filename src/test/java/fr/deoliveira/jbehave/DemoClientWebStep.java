package fr.deoliveira.jbehave;

import fr.deoliveira.jbehave.exception.DemoException;
import fr.deoliveira.jbehave.model.Client;
import fr.deoliveira.jbehave.settings.DemoProperties;
import lombok.extern.slf4j.Slf4j;
import org.jbehave.core.annotations.*;
import org.jbehave.core.model.ExamplesTable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;


@Component
@Slf4j
public class DemoClientWebStep {

    private WebDriver driver;

    @Autowired
    private DemoProperties properties;

    private void setup() {
        try {
            log.debug("SELENIUM URL {}", properties.getSeleniumUrl());
            log.debug("APPLICATION URL{}", properties.getApplicationUrl());
            driver = new RemoteWebDriver(
                    new URL(properties.getSeleniumUrl()),
                    DesiredCapabilities.firefox());
        } catch (MalformedURLException e) {
            throw new RuntimeException("Error during launching Selenium.");
        }
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    public void afterStory() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Given("Lancer l'application")
    public void launchApplication() throws InterruptedException {
        setup();
        driver.get(properties.getApplicationUrl());
    }

    @Given("Quitter l'application")
    public void exitApplication() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Given("Cliquer sur suppression")
    public void deleteAllClients() {
        driver.findElement(By.id("delete")).click();
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @When("Remplir le formulaire avec : \n $client")
    public void fillForm(ExamplesTable clientTable) {
        List<Map<String, String>> clientsRows = clientTable.getRows();
        if (clientsRows.isEmpty() || clientsRows.size() != 1) {
            throw new DemoException("On n'ajoute qu'un seul client à la fois");
        }
        Map<String, String> client = clientsRows.get(0);
        driver.findElement(By.id("lastName")).sendKeys(client.get("NOM"));
        driver.findElement(By.id("firstName")).sendKeys(client.get("PRENOM"));
        driver.findElement(By.id("age")).sendKeys(client.get("AGE"));
        driver.findElement(By.id("submitAdd")).click();
    }

    @Then("Le tableau de résultats contient $nb lignes")
    @Pending
    public void checkTable(int nb) {
        //Pending
    }
}
