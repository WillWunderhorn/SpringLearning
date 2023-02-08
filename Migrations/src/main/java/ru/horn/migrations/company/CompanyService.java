package ru.horn.migrations.company;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyService {

    private final CompanyDao companyDao;

    @Autowired
    public CompanyService(CompanyDao companyDao) {
        this.companyDao = companyDao;
    }

    public List<Company> getCompanies() {
        return companyDao.selectCompany();
    }

    public void addNewCompany(Company company) {
        int res = companyDao.insertCompany(company);
        if (res != 1) {
            throw new IllegalStateException("ADDING ERROR");
        }
    }

    public void deleteCompany(int id) {
        Optional<Company> company = companyDao.selectCompanyById(id);
        company.ifPresentOrElse(comp -> {
            int res = companyDao.deleteCompany(id);
            if (res != 1) {
                throw new IllegalStateException("DELETING ERROR");
            }
        }, () -> {
            throw new IllegalStateException(String.format("Company with id %s not found", id));
        });
    }

    public Company getCompany(int id) {
        return companyDao.selectCompanyById(id)
                .orElseThrow(() -> new IllegalStateException(String.format("Company with id %s not found", id)));
    }
}
