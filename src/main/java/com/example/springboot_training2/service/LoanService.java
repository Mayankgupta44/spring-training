package com.example.springboot_training2.service;

import com.example.springboot_training2.dto.LoanRequestDTO;
import com.example.springboot_training2.dto.LoanResponseDTO;
import com.example.springboot_training2.exception.LoanNotFoundException;
import com.example.springboot_training2.exception.UserNotFoundException;
import com.example.springboot_training2.mapper.LoanMapper;
import com.example.springboot_training2.model.Loan;
import com.example.springboot_training2.model.User;
import com.example.springboot_training2.repository.LoanRepository;
import com.example.springboot_training2.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class LoanService {

    private final LoanRepository loanRepository;
    private final UserRepository userRepository;
    private final LoanMapper loanMapper;

    public LoanService(LoanRepository loanRepository, UserRepository userRepository, LoanMapper loanMapper){
        this.loanRepository = loanRepository;
        this.userRepository = userRepository;
        this.loanMapper = loanMapper;
    }

    public LoanResponseDTO createLoan(LoanRequestDTO dto){
        User user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new UserNotFoundException("User not found"));

        Loan loan = new Loan();

        loan.setAmount(dto.getAmount());
        loan.setTenure(dto.getTenure());
        loan.setUser(user);

        Loan savedLoan = loanRepository.save(loan);

        return loanMapper.toResponseDto(savedLoan);
    }

    public LoanResponseDTO getLoanById(Long id) {
        Loan loan = loanRepository.findById(id)
                .orElseThrow(() -> new LoanNotFoundException("Loan not found"));

        return loanMapper.toResponseDto(loan);
    }

    @Transactional
    public LoanResponseDTO updateLoanById(Long id, LoanRequestDTO dto) {
        Loan existing = loanRepository.findById(id)
                .orElseThrow(() -> new LoanNotFoundException("Loan not found"));

        User user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new UserNotFoundException("User not found"));

        existing.setAmount(dto.getAmount());
        existing.setTenure(dto.getTenure());
        existing.setUser(user);

        return loanMapper.toResponseDto(existing);
    }

    public void deleteLoanById(Long id){
        loanRepository.findById(id)
                .orElseThrow(() -> new LoanNotFoundException("Loan not found"));

        loanRepository.deleteById(id);
    }

    public List<LoanResponseDTO> getAllLoans() {
        List<Loan> loans = loanRepository.findAll();

        List<LoanResponseDTO> response = new ArrayList<>();

        for(Loan loan: loans){
            LoanResponseDTO dto = loanMapper.toResponseDto(loan);

            response.add(dto);
        }

        return response;
    }

    public List<LoanResponseDTO> getLoansByUserId(Long userId) {
        List<LoanResponseDTO> loanList = new ArrayList<>();

        List<Loan> list = loanRepository.findByUserId(userId);

        for(Loan loan : list){
            loanList.add(loanMapper.toResponseDto(loan));
        }

        return loanList;
    }
}
