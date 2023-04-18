package com.corte2.taller1.controllers;

import com.corte2.taller1.models.Transaction;
import com.corte2.taller1.services.TransactionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TransactionController {

    TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    public List<Transaction> getAllTransaction() {
        return this.transactionService.getAllTransactionS();
    }

    public Transaction getTransaction(@PathVariable("id") long id) {
        return this.transactionService.getTransactionS(id);
    }

    public Boolean createTransaction(@RequestBody Transaction transaction) {
        return this.transactionService.createTransactionS(transaction);
    }

    public Boolean updateTransaction(@PathVariable("id") long id, @RequestBody Transaction transaction) {
        Transaction e1 = this.transactionService.getTransactionS(id);
        if (e1 != null) {
            try {
                return this.transactionService.updateTransactionS(transaction);
            } catch (Exception e) {
                return false;
            }
        } else {
            return false;
        }
    }

    public Boolean deleteTransaction(@PathVariable("id") long id) {
        return this.transactionService.deleteTransactionS(id);
    }
}
