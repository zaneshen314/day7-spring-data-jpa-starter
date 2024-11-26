package com.oocl.springbootemployee.service;

import com.oocl.springbootemployee.model.Company;
import com.oocl.springbootemployee.model.Employee;
import com.oocl.springbootemployee.repository.CompanyMemoryRepository;
import com.oocl.springbootemployee.repository.CompanyRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyService {
    private final CompanyMemoryRepository companyMemoryRepository;
    private final CompanyRepository companyRepository;

    public CompanyService(CompanyMemoryRepository companyMemoryRepository, CompanyRepository companyRepository) {
        this.companyMemoryRepository = companyMemoryRepository;
        this.companyRepository = companyRepository;
    }

    public List<Company> findAll(){
        return companyRepository.findAll();
    }

    public List<Company> findAll(int pageIndex, int pageSize) {
        List<Company> companiesInPage = companyMemoryRepository.getCompaniesByPagination(pageIndex, pageSize);
        return companiesInPage.stream().toList();
    }

    public Company findById(Integer id) {
        return companyMemoryRepository.findById(id);
    }


    public List<Employee> getEmployeesByCompanyId(Integer id) {
        Company company = companyMemoryRepository.findById(id);
        return company.getEmployees();
    }

    public Company create(Company company) {
        return companyMemoryRepository.addCompany(company);
    }

    public Company update(Integer id, Company company) {
        final var companyNeedToUpdate = companyMemoryRepository
                .findById(id);

        var nameToUpdate = company.getName() == null ? companyNeedToUpdate.getName() : company.getName();
        var employeesToUpdate = company.getEmployees() == null ? companyNeedToUpdate.getEmployees() : company.getEmployees();

        final var companyToUpdate = new Company(id,nameToUpdate,employeesToUpdate);
        return companyMemoryRepository.updateCompany(id, companyToUpdate);
    }
}
