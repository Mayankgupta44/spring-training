package com.example.springboot_training2.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoanRequestDTO {
    @Min(value = 1, message = "Amount must be greater than 1")
    private double amount;

    @Min(value = 1, message = "Tenure must be greater than 1 month")
    private int tenure;

    @NotNull(message = "User ID is required")
    private Long userId;
}
