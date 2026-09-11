package com.example.springboot_training2.controller;

import com.example.springboot_training2.dto.LoanRequestDTO;
import com.example.springboot_training2.dto.LoanResponseDTO;
import com.example.springboot_training2.model.Loan;
import com.example.springboot_training2.service.LoanService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/loans")
public class LoanController {

    private final LoanService loanService;

    LoanController(LoanService loanService){
        this.loanService = loanService;
    }

    @PostMapping
    public ResponseEntity<LoanResponseDTO> creatLoan(@Valid @RequestBody LoanRequestDTO dto){
        LoanResponseDTO response = loanService.createLoan(dto);

        return ResponseEntity.status(201).body(response);
    }

    @GetMapping("/{id}")
    public  LoanResponseDTO getLoanById(@PathVariable Long id){
        return loanService.getLoanById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<LoanResponseDTO> updateLoanById(@PathVariable Long id, @Valid @RequestBody LoanRequestDTO dto){
        LoanResponseDTO response = loanService.updateLoanById(id, dto);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLoanById(@PathVariable Long id){
        loanService.deleteLoanById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public List<LoanResponseDTO> getAllLoans(){
        return loanService.getAllLoans();
    }

    @GetMapping("/users/{userId}/loans")
    public List<LoanResponseDTO> getUserAllLoans(@PathVariable Long userId){
        return loanService.getLoansByUserId(userId);
    }
}
