package com.spring.spring_first.service.impl;

import com.spring.spring_first.model.Project;
import com.spring.spring_first.model.Transaction;
import com.spring.spring_first.repository.ProjectRepository;
import com.spring.spring_first.repository.TransactionRepository;
import com.spring.spring_first.service.TransactionService;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {
    private final TransactionRepository transactionRepository;
    private final ProjectRepository projectRepository;

    public TransactionServiceImpl(TransactionRepository transactionRepository, ProjectRepository projectRepository) {
        this.transactionRepository = transactionRepository;
        this.projectRepository = projectRepository;
    }

    @Override
    public Transaction save(Transaction transaction, Model model) {
        Project project = projectRepository.findById(transaction.getProject().getId()).orElse(null);
        if(project == null){
            // Project selection mendatory
            return null;
        }
        transaction.setProject(project);
        return transactionRepository.save(transaction);
    }

    @Override
    public List<Transaction> list() {
        return transactionRepository.findAllByOrderByIdDesc();
    }
}
