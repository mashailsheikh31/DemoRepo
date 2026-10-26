package com.example.ExpenseTracker.service;


import com.example.ExpenseTracker.model.Expense;
import com.example.ExpenseTracker.repo.ExpenseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ExpenseService {

    @Autowired
    private ExpenseRepo expenseRepo;

    // Add new expense
    public Expense addExpense(Expense expense) {
        return expenseRepo.save(expense);
    }

    // Get all expenses by user
    public List<Expense> getAllExpenses(Long userId) {
        return expenseRepo.findByUserId(userId);
    }


    // Filter by category
    public List<Expense> getExpensesByCategory(Long userId, String category) {
        return expenseRepo.findByUserIdAndCategory(userId, category);
    }
    // Filter by date range
    public List<Expense> getExpensesByDateRange(Long userId, LocalDate startDate, LocalDate endDate) {
        return expenseRepo.findByUserIdAndDateBetween(userId, startDate, endDate);
    }
    //Category-wise summary (e.g., Food: 1000, Travel: 2000)
    public Map<String, Double> getCategoryWiseSummary(Long userId) {
        List<Expense> expenses = expenseRepo.findByUserId(userId);

        Map<String, Double> summary = new HashMap<>();
        for (Expense expense : expenses) {
            String category = expense.getCategory();
            double amount = expense.getAmount();

            // Agar category already exist hai to purane amount me add karo
            summary.put(category, summary.getOrDefault(category, 0.0) + amount);
        }
        return summary;
    }
}
