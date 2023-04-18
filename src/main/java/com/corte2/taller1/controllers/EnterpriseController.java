package com.corte2.taller1.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.corte2.taller1.models.Enterprise;
import com.corte2.taller1.services.EnterpriseService;

@RestController
public class EnterpriseController {

    EnterpriseService enterpriseServices;

    public EnterpriseController(EnterpriseService enterpriseServices) {
        this.enterpriseServices = enterpriseServices;
    }

    public List<Enterprise> getAllEnterprise() {
        return this.enterpriseServices.getAllEnterpriseS();
    }

    public Enterprise getEnterprise(@PathVariable("id") long id) {
        return this.enterpriseServices.getEnterpriseS(id);
    }

    public Boolean createEnterprise(Enterprise enterprise) {
        return this.enterpriseServices.createEnterpriseS(enterprise);
    }

    public Boolean updateEnterprise(long id, Enterprise enterprise) {
        Enterprise e1 = this.enterpriseServices.getEnterpriseS(id);
        if (e1 != null) {
            try {
                return this.enterpriseServices.updateEnterpriseS(enterprise);
            } catch (Exception e) {
                return false;
            }
        } else {
            return false;
        }
    }

    public Boolean deleteEnterprise(long id) {
        return this.enterpriseServices.deleteEnterpriseS(id);
    }

    @GetMapping("/enterprise/{id}")
    public Enterprise getEnterpriseById(@PathVariable("id") long id) {
        return this.enterpriseServices.getEnterpriseS(id);
    }

    /*
     * @Autowired
     * private EnterpriseRepository EnterpriseRepository;
     * 
     * public void printAllenterprise() {
     * List<Enterprise> enterprise = EnterpriseRepository.findAll();
     * for (Enterprise Enterprise : enterprise) {
     * System.out.println(Enterprise.getName() + " " + Enterprise.getPhone());
     * }
     * }
     * 
     * @Autowired
     * private EntityManager entityManager;
     * 
     * public void executeQuery() {
     * String sql = "SELECT * FROM enterprise";
     * Query query = entityManager.createNativeQuery(sql, Enterprise.class);
     * List<Enterprise> enterprise = query.getResultList();
     * for (Enterprise Enterprise : enterprise) {
     * System.out.println(Enterprise.getName() + " " + Enterprise.getPhone());
     * }
     * }
     * 
     * @GetMapping("/enterprise")
     * public List<Enterprise> getenterprise() {
     * return EnterpriseRepository.findAll();
     * }
     */
}
