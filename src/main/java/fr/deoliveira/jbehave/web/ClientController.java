package fr.deoliveira.jbehave.web;

import fr.deoliveira.jbehave.service.ClientService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.annotation.RequestScope;

@Controller
@RequestMapping("/clients")
@Slf4j
public class ClientController {

    private ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/all")
    public String getAll(Model model) {
        log.info("TEST CLIENTS");
        model.addAttribute("client", clientService.getAllClients().get(0));
        return "clients";
    }

}
