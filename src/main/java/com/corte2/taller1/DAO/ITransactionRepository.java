package com.corte2.taller1.DAO;

import com.corte2.taller1.models.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITransactionRepository extends JpaRepository<Transaction, Long> {
    Transaction findById(long Id);
}
