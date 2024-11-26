package com.oocl.springbootemployee.service;

import com.oocl.springbootemployee.model.Company;
import com.oocl.springbootemployee.model.Employee;
import com.oocl.springbootemployee.repository.CompanyMemoryRepository;
import com.oocl.springbootemployee.repository.CompanyRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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

    public  Page<Company> findAll(int pageIndex, int pageSize) {
        PageRequest pageRequest = PageRequest.of(pageIndex - 1, pageSize);
        Page<Company> companyPage = companyRepository.findAll(pageRequest);
        return companyPage;
    }

    public Company findById(Integer id) {
        return companyRepository.findById(id).orElse(null);
    }


    public List<Employee> getEmployeesByCompanyId(Integer id) {
        Company company = companyRepository.findById(id).orElse(null);
        return company != null ? company.getEmployees() : null;
    }

    public Company create(Company company) {
        return companyRepository.save(company);
    }

    public Company update(Integer id, Company company) {
        final var companyNeedToUpdate = companyRepository
                .findById(id).orElse(null);
        if (companyNeedToUpdate == null){
            return null;
        }
        var nameToUpdate = company.getName() == null ? companyNeedToUpdate.getName() : company.getName();
        var employeesToUpdate = company.getEmployees() == null ? companyNeedToUpdate.getEmployees() : company.getEmployees();
        final var companyToUpdate = new Company(id,nameToUpdate,employeesToUpdate);
        return companyRepository.saveAndFlush(companyToUpdate);
    }

    public void deleteById(Integer id) {
        companyRepository.deleteById(id);
    }
}
