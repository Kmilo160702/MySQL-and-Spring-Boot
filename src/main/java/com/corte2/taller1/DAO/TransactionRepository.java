package com.corte2.taller1.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.corte2.taller1.models.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

}
