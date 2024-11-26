package com.oocl.springbootemployee.service;

import com.oocl.springbootemployee.exception.EmployeeAgeNotValidException;
import com.oocl.springbootemployee.exception.EmployeeAgeSalaryNotMatchedException;
import com.oocl.springbootemployee.exception.EmployeeInactiveException;
import com.oocl.springbootemployee.model.Employee;
import com.oocl.springbootemployee.model.Gender;
import com.oocl.springbootemployee.repository.EmployeeMemoryRepository;
import java.util.List;

import com.oocl.springbootemployee.repository.EmployeeRepository;
import org.springframework.stereotype.Service;
@Service
public class EmployeeService {
    private final EmployeeMemoryRepository employeeMemoryRepository;
    private final EmployeeRepository employeeRepository;
    public EmployeeService(EmployeeMemoryRepository employeeMemoryRepository, EmployeeRepository employeeRepository) {
        this.employeeMemoryRepository = employeeMemoryRepository;
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    public List<Employee> findAll(Gender gender) {
        return employeeMemoryRepository.findAllByGender(gender);
    }

    public List<Employee> findAll(Integer page, Integer pageSize) {
        return employeeMemoryRepository.findAllByPage(page, pageSize);
    }

    public Employee findById(Integer employeeId) {
        return employeeMemoryRepository.findById(employeeId);
    }

    public Employee create(Employee employee) {
        if(employee.getAge() < 18 || employee.getAge() > 65)
            throw new EmployeeAgeNotValidException();
        if(employee.getAge() >= 30 && employee.getSalary() < 20000.0)
            throw new EmployeeAgeSalaryNotMatchedException();

        employee.setActive(true);
        return employeeMemoryRepository.create(employee);
    }

    public Employee update(Integer employeeId , Employee employee) {
        Employee employeeExisted = employeeMemoryRepository.findById(employeeId);
        if(!employeeExisted.getActive())
            throw new EmployeeInactiveException();

        return employeeMemoryRepository.update(employeeId, employee);
    }

    public void delete(Integer employeeId) {
        employeeMemoryRepository.deleteById(employeeId);
    }
}
