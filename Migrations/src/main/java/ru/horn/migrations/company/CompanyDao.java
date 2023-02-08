package ru.horn.migrations.company;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface CompanyDao {
    List<Company> selectCompany();
    int insertCompany(Company company);
    int deleteCompany(int id);
    Optional<Company> selectCompanyById(int id);
}
