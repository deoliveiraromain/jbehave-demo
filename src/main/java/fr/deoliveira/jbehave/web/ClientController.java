package fr.deoliveira.jbehave.web;

import fr.deoliveira.jbehave.model.Client;
import fr.deoliveira.jbehave.service.ClientService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@Slf4j
public class ClientController {

    private ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/")
    public String getAll(Model model) {
        log.info("getting all clients");
        model.addAttribute("clients", clientService.getAllClients());
        return "clients";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/delete")
    public String deleteAll(RedirectAttributes redirectAttributes) {
        log.info("Deleting all clients");
        this.clientService.deleteAllClients();
        redirectAttributes.addFlashAttribute("deleteOk", true);
        return "redirect:/";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/add")
    public String addClient(RedirectAttributes redirectAttributes, @RequestParam("lastName") String lastName, @RequestParam("firstName") String firstName,
                            @RequestParam("age") int age) {
        log.info("Adding client in Database");
        Client client = new Client(lastName, firstName, age);
        clientService.addClient(client);
        redirectAttributes.addFlashAttribute("addOk", true);
        return "redirect:/";
    }


}
