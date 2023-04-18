package com.corte2.taller1.services;

import com.corte2.taller1.models.Transaction;

import java.util.List;

public interface ITransactionService {
    List<Transaction> getAllTransactionS();

    Transaction getTransactionS(long id);

    Boolean createTransactionS(Transaction transaction);

    Boolean updateTransactionS(Transaction transaction);

    Boolean deleteTransactionS(long id);
}