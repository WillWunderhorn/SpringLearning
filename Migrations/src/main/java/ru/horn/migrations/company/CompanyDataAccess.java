package ru.horn.migrations.company;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CompanyDataAccess implements CompanyDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public CompanyDataAccess(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Company> selectCompany() {
        String sql = """
                SELECT id, name, date
                FROM company
                LIMIT 100;
                """;
        return jdbcTemplate.query(sql, new
                CompanyRowMapper());
    }

    @Override
    public int insertCompany(Company company) {
        String sql = """
                INSERT INTO company(name, date)
                VALUES(?, ?);
                """;
        return jdbcTemplate.update(
                sql,
                company.name(), company.date()
        );
    }

    @Override
    public int deleteCompany(int id) {
//        var sql = """
//                DELETE FROM company
//                WHERE id = ?
//                """;
//        return jdbcTemplate.update(sql, id);
        throw new UnsupportedOperationException("not implemented");
    }

    @Override
    public Optional<Company> selectCompanyById(int id) {
//        var sql = """
//                SELECT id, name, date
//                FROM company
//                WHERE id = ?
//                """;
//        return jdbcTemplate.query(sql, new CompanyRowMapper(), id)
//                .stream()
//                .findFirst();
//    }
        throw new UnsupportedOperationException("not implemented");
    }
}
