package com.example.ExpenseTracker.controller;


import com.example.ExpenseTracker.model.Expense;
import com.example.ExpenseTracker.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://127.0.0.1:5500")
@RestController
@RequestMapping("/exp")
public class ExpenseController {

    @Autowired
    private ExpenseService expenseService;

    @PostMapping
    public Expense addExpense(@RequestBody Expense expense){
        return expenseService.addExpense(expense);
    }

    @GetMapping("/{userId}")
    public List<Expense> getAllExp(@PathVariable("userId") Long userId) {
        return expenseService.getAllExpenses(userId);
    }


    @GetMapping("/{userId}/category/{category}")
    public List<Expense> getByCategory(@PathVariable Long userId, @PathVariable String category){
        return expenseService.getExpensesByCategory(userId,category);
    }

    @GetMapping("/{userId}/dates")
    public List<Expense> getByDateRange(@PathVariable Long userId, @RequestParam LocalDate startDate,@RequestParam LocalDate endDate ){
        return expenseService.getExpensesByDateRange(userId,startDate,endDate);
    }

    @GetMapping("/{userId}/summary")
    public Map<String, Double> getSummary(@PathVariable Long userId) {
        return expenseService.getCategoryWiseSummary(userId);
    }



}
