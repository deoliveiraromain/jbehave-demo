package fr.deoliveira.jbehave.service;


import fr.deoliveira.jbehave.model.Client;
import fr.deoliveira.jbehave.rowmapper.ClientMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.List;

@Service
@Slf4j
public class ClientServiceImpl implements ClientService {

    private static final String GET_ALL_CLIENTS = "SELECT * FROM CLIENT";

    private static final String DELETE_ALL_CLIENTS = "DELETE FROM CLIENT";

    private static final String INSERT_CLIENT = "INSERT INTO CLIENT (last_name,first_name,age) VALUES (?,?,?)";

    private static final String SEARCH_CLIENT = "SELECT * FROM CLIENT WHERE last_name='%s'";

    private final JdbcTemplate jdbcTemplate;


    @Autowired
    public ClientServiceImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Client> getAllClients() {
        log.debug("Service layer, get all client");
        return jdbcTemplate.query(GET_ALL_CLIENTS, new ClientMapper());
    }

    @Override
    @Transactional
    public void deleteAllClients() {
        log.debug("Service layer, deleting  all clients");
        this.jdbcTemplate.update(DELETE_ALL_CLIENTS);
    }

    @Override
    @Transactional
    public void addClient(Client client) {
        log.debug("Service layer, adding client {}", client);
        this.jdbcTemplate.update(INSERT_CLIENT, client.getLastName(), client.getFirstName(), client.getAge());

    }

    @Override
    public List<Client> searchByLastName(String lastName) {
        return this.jdbcTemplate.query(String.format(SEARCH_CLIENT, lastName), new ClientMapper());
    }
}
