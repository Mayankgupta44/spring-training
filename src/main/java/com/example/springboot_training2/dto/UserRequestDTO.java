package com.example.springboot_training2.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRequestDTO {
    @NotBlank(message = "Name cant be empty")
    private String name;

    @Min(value = 18, message = "Age should be at least 18")
    @Max(value = 100, message = "Age should be at most 100")
    private int age;

    @Pattern(regexp = "\\d{10}", message = "Contact must contain exactly 10 digits")
    private String contact;
}
