package com.example.springboot_training2.mapper;

import com.example.springboot_training2.dto.LoanRequestDTO;
import com.example.springboot_training2.dto.LoanResponseDTO;
import com.example.springboot_training2.model.Loan;
import org.springframework.stereotype.Component;

@Component
public class LoanMapper {

    public LoanResponseDTO toResponseDto(Loan loan){
        LoanResponseDTO dto = new LoanResponseDTO();

        dto.setAmount(loan.getAmount());
        dto.setTenure(loan.getTenure());
        dto.setUserId(loan.getUser().getId());
        dto.setId(loan.getId());

        return dto;
    }

}
