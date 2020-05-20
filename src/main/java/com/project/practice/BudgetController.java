package com.project.practice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BudgetController {

    @Autowired
    private BudgetService budgetService;

    @RequestMapping("/budgets")
    public List<Budget> getBudgets(){
        return budgetService.getAllBudgets();
    }

    @RequestMapping("/budgets/{name}")
    public Budget getBudget(@PathVariable String name){
        return budgetService.getBudget(name);
    }

}
