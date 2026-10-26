package com.example.ExpenseTracker.repo;

import com.example.ExpenseTracker.model.Expense;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.time.LocalDate;
import java.util.List;

public interface ExpenseRepo extends MongoRepository<Expense, String> {
    List<Expense> findByUserId(Long userId);

    List<Expense> findByUserIdAndCategory(Long userId, String category);

    List<Expense> findByUserIdAndDateBetween(Long userId, LocalDate startDate, LocalDate endDate);
}
