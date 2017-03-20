package fr.deoliveira.jbehave.web;

import fr.deoliveira.jbehave.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.annotation.RequestScope;

@Controller
@RequestMapping("/clients")
public class ClientController {

    private ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/method1")
    public String getAll(Model model) {
        clientService.getAllClients();
        return "clients";
    }

}
