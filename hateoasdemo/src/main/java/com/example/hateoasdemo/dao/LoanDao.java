package com.example.hateoasdemo.dao;

import com.example.hateoasdemo.entity.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LoanDao extends JpaRepository<Loan, Long> {

    public Optional<Loan> findByLoanId(int loanId);


}
