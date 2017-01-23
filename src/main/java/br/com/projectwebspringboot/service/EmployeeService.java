package br.com.projectwebspringboot.service;

import br.com.projectwebspringboot.domain.Employee;

public interface EmployeeService {
    
    Iterable <Employee> listAllEmployee();
    
    Employee getEmployeeById(Long id);
    
    Employee saveEmployee(Employee employee);
    
    void deleteEmployee(Long id);
}
