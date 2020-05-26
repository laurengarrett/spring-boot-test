package com.project.practice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(method=RequestMethod.POST, value="/budgets")
    public void addBudget(@RequestBody Budget budget){
        budgetService.addBudget(budget);
    }

    @RequestMapping(method=RequestMethod.PUT, value="/budgets/{name}")
    public void updateBudget(@RequestBody Budget budget, @PathVariable String name){
        budgetService.updateBudget(name, budget);
    }

    @RequestMapping(method=RequestMethod.DELETE, value="/budgets/{name}")
    public void deleteBudget(@PathVariable String name){
        budgetService.deleteBudget(name);
    }


}
