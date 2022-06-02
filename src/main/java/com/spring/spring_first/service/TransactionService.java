package com.spring.spring_first.service;

import com.spring.spring_first.model.Transaction;
import org.springframework.ui.Model;

import java.util.List;

public interface TransactionService {

    Transaction save(Transaction transaction, Model model);

    List<Transaction> list();
}
