package com.corte2.taller1.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.corte2.taller1.models.Employee;
import com.corte2.taller1.DAO.IEmployeeRepository;

@Service
public class EmployeeService implements IEmployeeService {

    private final IEmployeeRepository employeeRepository;

    public EmployeeService(IEmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> getAllEmployeeS() {
        return this.employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeS(long id) {
        return this.employeeRepository.findById(id);
    }

    @Override
    public Boolean createEmployeeS(Employee employee) {
        if (employee.getId() == 0L) {
            this.employeeRepository.save(employee);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Boolean updateEmployeeS(Employee employee) {
        try {
            this.employeeRepository.save(employee);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Boolean deleteEmployeeS(long id) {
        try {
            this.employeeRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
