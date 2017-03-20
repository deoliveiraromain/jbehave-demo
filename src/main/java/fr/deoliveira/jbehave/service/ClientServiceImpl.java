package fr.deoliveira.jbehave.service;


import fr.deoliveira.jbehave.model.Client;
import fr.deoliveira.jbehave.rowmapper.ClientMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ClientServiceImpl implements ClientService {

    private static final String GET_ALL_CLIENT = "SELECT * FROM CLIENT";

    private final JdbcTemplate jdbcTemplate;


    @Autowired
    public ClientServiceImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public List<Client> getAllClients() {
        return jdbcTemplate.query(GET_ALL_CLIENT,new ClientMapper());
    }
}
