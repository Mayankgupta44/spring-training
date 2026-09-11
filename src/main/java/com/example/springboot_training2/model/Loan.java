package com.example.springboot_training2.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "loans")
public class Loan {

    @Id
    @GeneratedValue
    private Long id;

    private double amount;
    private int tenure;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
