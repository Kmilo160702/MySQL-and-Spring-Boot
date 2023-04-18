package com.corte2.taller1.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.corte2.taller1.models.Employee;
import com.corte2.taller1.services.EmployeeService;

@RestController
@RequestMapping("employee")
public class EmployeeController {
    EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public List<Employee> getAllEmployee() {
        return this.employeeService.getAllEmployeeS();
    }

    public Employee getEmployee(@PathVariable("id") long id) {
        return this.employeeService.getEmployeeS(id);
    }

    public Boolean createEmployee(@RequestBody Employee employee) {
        return this.employeeService.createEmployeeS(employee);
    }

    public Boolean updateEmployee(@PathVariable("id") long id, @RequestBody Employee employee) {
        Employee e1 = this.employeeService.getEmployeeS(id);
        if (e1 != null) {
            try {
                return this.employeeService.updateEmployeeS(employee);
            } catch (Exception e) {
                return false;
            }
        } else {
            return false;
        }
    }

    public Boolean deleteEmployee(@PathVariable("id") long id) {
        return this.employeeService.deleteEmployeeS(id);
    }

}
