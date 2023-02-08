package ru.horn.migrations.company;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class CompanyController {

    private final CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping("/")
    public List<Company> companyList() {
        return companyService.getCompanies();
    }

    @GetMapping("{id}")
    public Company getCompanyId(@PathVariable("id") int id) {
        return companyService.getCompany(id);
    }

    @PostMapping("/")
    public void addCompany(@RequestBody Company company){
        companyService.addNewCompany(company);
    }

    @DeleteMapping("{id}")
    public void deleteCompany(@PathVariable("id") int id) {
        companyService.deleteCompany(id);
    }
}
