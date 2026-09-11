package com.example.springboot_training2.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoanResponseDTO {
    private Long id;
    private double amount;
    private int tenure;
    private Long userId;
}
