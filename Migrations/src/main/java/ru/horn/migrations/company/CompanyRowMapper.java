package ru.horn.migrations.company;

import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public class CompanyRowMapper implements RowMapper<Company> {
    @Override
    public Company mapRow(ResultSet resultSet, int i) throws SQLException {
        return new Company(
                resultSet.getLong("id"),
                resultSet.getString("name"),
                List.of(),
                LocalDate.parse(resultSet.getString("date"))
        );
    }
}
