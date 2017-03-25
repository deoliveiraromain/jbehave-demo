package fr.deoliveira.jbehave.rowmapper;

import fr.deoliveira.jbehave.model.Client;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ClientMapper implements RowMapper<Client> {

    private static final String ID = "id";
    private static final String FIRSTNAME = "first_name";
    private static final String LASTNAME = "last_name";
    private static final String AGE = "age";

    @Override
    public Client mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Client(rs.getInt(ID), rs.getString(LASTNAME), rs.getString(FIRSTNAME), rs.getInt(AGE));
    }
}
