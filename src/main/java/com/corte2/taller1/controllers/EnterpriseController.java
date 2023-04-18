package com.corte2.taller1.controllers;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.corte2.taller1.DAO.EnterpriseRepository;
import com.corte2.taller1.models.Enterprise;

@RestController
public class EnterpriseController {

    @Autowired
    private EnterpriseRepository EnterpriseRepository;

    public void printAllenterprise() {
        List<Enterprise> enterprise = EnterpriseRepository.findAll();
        for (Enterprise Enterprise : enterprise) {
            System.out.println(Enterprise.getName() + " " + Enterprise.getPhone());
        }
    }

    @Autowired
    private EntityManager entityManager;

    public void executeQuery() {
        String sql = "SELECT * FROM enterprise";
        Query query = entityManager.createNativeQuery(sql, Enterprise.class);
        List<Enterprise> enterprise = query.getResultList();
        for (Enterprise Enterprise : enterprise) {
            System.out.println(Enterprise.getName() + " " + Enterprise.getPhone());
        }
    }

    @GetMapping("/enterprise")
    public List<Enterprise> getenterprise() {
        return EnterpriseRepository.findAll();
    }
}
