package com.project.practice;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class BudgetService {

    private List<Budget> budgets = new ArrayList<>(Arrays.asList(
            new Budget("1", "Expenses", 600.00, "2020-05-17", "2020-05-23"),
            new Budget("2", "Fun Money", 125.00, "2020-05-01", "2020-05-31"),
            new Budget("3", "Savings", 1000.00, "2020-05-01", "2020-05-31")
    ));

    public List<Budget> getAllBudgets(){
        return budgets;
    }

    public Budget getBudget(String name){
        return budgets.stream().filter(b -> b.getName().equals(name)).findFirst().get();
    }

    public void addBudget(Budget budget) {
        budgets.add(budget);
    }

    public void updateBudget(String name, Budget budget){
        for (int i=0; i<budgets.size(); i++){
            Budget b = budgets.get(i);
            if (b.getName().equals(name)){
                budgets.set(i, budget);
                return;
            }
        }
    }

    public void deleteBudget(String name) {
        budgets.removeIf(b -> b.getName().equals(name));
    }
}
