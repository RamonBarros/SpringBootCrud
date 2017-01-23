package br.com.projectwebspringboot.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.projectwebspringboot.domain.Employee;
import br.com.projectwebspringboot.integration.EmployeeRepository;
import br.com.projectwebspringboot.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    
    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public Iterable<Employee> listAllEmployee() {
        
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(Long id) {

        return employeeRepository.findOne(id);
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        
        return employeeRepository.save(employee);
    }

    @Override
    public void deleteEmployee(Long id) {
        
        employeeRepository.delete(id);
    }
    
    
}
