package fr.deoliveira.jbehave.service;


import fr.deoliveira.jbehave.model.Client;

import java.util.List;

public interface ClientService {

    List<Client> getAllClients();

    void deleteAllClients();

    void addClient(Client client);

    List<Client> searchByLastName(String lastName);

}
