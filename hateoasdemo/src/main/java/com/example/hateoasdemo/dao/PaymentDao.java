package com.example.hateoasdemo.dao;

import com.example.hateoasdemo.entity.Payment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentDao extends JpaRepository<Payment, Long> {

   Page<Payment> findByLoanLoanId(int loanId, Pageable pageable);

}
