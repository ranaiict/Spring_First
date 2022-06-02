package com.spring.spring_first.controller;

import com.spring.spring_first.model.Transaction;
import com.spring.spring_first.service.ProjectService;
import com.spring.spring_first.service.TransactionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/transaction")
public class TransactionController {
    private final TransactionService transactionService;
    private final ProjectService projectService;

    public TransactionController(TransactionService transactionService, ProjectService projectService) {
        this.transactionService = transactionService;
        this.projectService = projectService;
    }

    @GetMapping("/addVoucher")
    public String addVoucher(Model model, @ModelAttribute Transaction transaction){
        model.addAttribute("projectList", projectService.list());
        model.addAttribute("transactionList", transactionService.list());
        return "addVoucher.html";
    }

    @PostMapping("/addVoucherData")
    public String addVoucherData(Model model, @ModelAttribute Transaction transaction){
        transaction = transactionService.save(transaction, model);
        if (transaction != null){
            model.addAttribute("result","Transaction Added....");
        } else {
            model.addAttribute("result","Transaction Not Added....");
        }
        model.addAttribute("projectList", projectService.list());
        model.addAttribute("transactionList", transactionService.list());
        return "addVoucher.html";
    }

}
