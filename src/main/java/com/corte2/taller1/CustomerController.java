package com.corte2.taller1;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    public void printAllCustomers() {
        List<Customer> customers = customerRepository.findAll();
        for (Customer customer : customers) {
            System.out.println(customer.getFirstName() + " " + customer.getLastName());
        }
    }

    @Autowired
    private EntityManager entityManager;

    public void executeQuery() {
        String sql = "SELECT * FROM customers";
        Query query = entityManager.createNativeQuery(sql, Customer.class);
        List<Customer> customers = query.getResultList();
        for (Customer customer : customers) {
            System.out.println(customer.getFirstName() + " " + customer.getLastName());
        }
    }

    @GetMapping("/customers")
    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }
}
