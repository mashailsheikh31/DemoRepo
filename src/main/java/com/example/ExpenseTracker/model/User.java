package com.example.ExpenseTracker.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "listUsers")
public class User {
    @Id
private String id;
    @Email(message = "Valid email required")
    @NotBlank(message = "Email required")
private String email;
    @NotBlank(message = "Password required")
    @Size(min = 6, message = "Password must be at least 6 characters")
private String password;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    @NotBlank(message = "Full name required")

    private String fullName;
}
