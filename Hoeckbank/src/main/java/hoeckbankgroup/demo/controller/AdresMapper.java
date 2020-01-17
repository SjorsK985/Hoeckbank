package hoeckbankgroup.demo.controller;

import hoeckbankgroup.demo.model.AddressPart;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

class AdresMapper implements RowMapper<AddressPart> {

    @Override
    public AddressPart mapRow(ResultSet resultSet, int i) throws SQLException {
        return new AddressPart(resultSet.getString("straat"), resultSet.getString("stad"));
    }
}
