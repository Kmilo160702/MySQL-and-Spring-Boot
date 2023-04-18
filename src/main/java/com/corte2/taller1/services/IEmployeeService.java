package com.corte2.taller1.services;

import com.corte2.taller1.models.Employee;

import java.util.List;

public interface IEmployeeService {
    List<Employee> getAllEmployeeS();

    Employee getEmployeeS(long id);

    Boolean createEmployeeS(Employee employee);

    Boolean updateEmployeeS(Employee employee);

    Boolean deleteEmployeeS(long id);
}
