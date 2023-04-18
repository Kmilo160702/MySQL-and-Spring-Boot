package com.corte2.taller1.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.corte2.taller1.models.Employee;

@Repository
public interface IEmployeeRepository extends JpaRepository<Employee, Long> {
    Employee findById(long Id);
}
