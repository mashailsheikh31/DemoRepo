package com.example.ExpenseTracker.repo;

import com.example.ExpenseTracker.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepo extends MongoRepository<User , String> {
     

//    boolean existByEmail(String email);

    User findByEmail(String email);
}
