package br.com.projectwebspringboot.integration;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.projectwebspringboot.domain.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long>{

}

