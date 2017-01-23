package br.com.projectwebspringboot.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.projectwebspringboot.domain.Employee;
import br.com.projectwebspringboot.service.EmployeeService;

@RestController
public class EmployeeController {
    
    @Autowired
    private EmployeeService employeeService;
    
    @RequestMapping(value = "/employees", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<List<Employee>> list() {
       
       return new ResponseEntity<List<Employee>>((List<Employee>) employeeService.listAllEmployee(), HttpStatus.FOUND);
    }
    
    @RequestMapping(value = "employee/{id}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<Employee> showProduct(@PathVariable Long id) {
        
        return new ResponseEntity<Employee>(employeeService.getEmployeeById(id), HttpStatus.FOUND);
    }
    
    @RequestMapping("employee/new")
    public String newProduct(Model model) {
        model.addAttribute("product", new Employee());
        return "employeeform";
    }
    
    @RequestMapping(value = "employee", method = RequestMethod.POST,  consumes = "application/json")
    public String saveProduct(@RequestBody  Employee employee) {
        
        employeeService.saveEmployee(employee);
        return "redirect:/employee/" + employee.getIdEmployee();
    }
    
    @RequestMapping(value = "employee/update", method = RequestMethod.PUT,  consumes = "application/json")
    public String updateProduct(@RequestBody  Employee employee) {

        Employee newEmployee = new Employee();
        newEmployee = employeeService.getEmployeeById(employee.getIdEmployee());
        if (employee.getNameEmployee() != null){
            newEmployee.setNameEmployee(employee.getNameEmployee());
        }
        if (employee.getDepartmentEmployee() != null){
            newEmployee.setDepartmentEmployee(employee.getDepartmentEmployee());
        }
        if (employee.getNumberEmployee() != null){
            newEmployee.setNumberEmployee(employee.getNumberEmployee());
        }
        if (employee.getPostEmployee() != null){
            newEmployee.setPostEmployee(employee.getPostEmployee());
        }
        employeeService.saveEmployee(newEmployee);
        return "redirect:/employee/update" + employee.getIdEmployee();
    }
    
    @RequestMapping("employee/delete/{id}")
    public String delete(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
        return "redirect:/employees";
    }
}
