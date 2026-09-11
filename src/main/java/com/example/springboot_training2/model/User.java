package com.example.springboot_training2.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private int age;

    @Column(unique=true, nullable = false)
    private String contact;

    @OneToMany(mappedBy = "user")
    private List<Loan> loans;

}
