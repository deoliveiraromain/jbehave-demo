package fr.deoliveira.jbehave;

import fr.deoliveira.jbehave.exception.DemoException;
import fr.deoliveira.jbehave.model.Client;
import fr.deoliveira.jbehave.service.ClientService;
import lombok.extern.slf4j.Slf4j;
import org.jbehave.core.annotations.*;
import org.jbehave.core.model.ExamplesTable;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;


@Component
@Slf4j
public class DemoClientServiceStep {

    private ClientService clientService;

    @Autowired
    public DemoClientServiceStep(ClientService clientService) {
        this.clientService = clientService;
    }


    @Given("La base de données est vidée")
    public void emptyDb() {
        this.clientService.deleteAllClients();
    }

    @When("Ajouter les clients : $clientsTable")
    public void addClients(ExamplesTable clientsTable) {
        List<Map<String, String>> clientsRows = clientsTable.getRows();
        clientsRows.stream().forEach(c -> clientService.addClient(new Client(c.get("NOM"), c.get("PRENOM"), Integer.valueOf(c.get("AGE")))));
    }

    @Then("Le nombre de clients dans la base est $nb")
    public void checkNumberOfClients(int nb) {
        Assert.assertEquals(nb, this.clientService.getAllClients().size());
    }

    @Then("Le résultat de la recherche de $lastName renvoie $nb résultat")
    public void checkSearch(String lastName, int nb){
        Assert.assertEquals(nb,this.clientService.searchByLastName(lastName).size());
    }
}
