package com.example.hateoasdemo.services;

import com.example.hateoasdemo.dao.CustomerDao;
import com.example.hateoasdemo.dao.LoanDao;
import com.example.hateoasdemo.dao.PaymentDao;
import com.example.hateoasdemo.entity.Customer;
import com.example.hateoasdemo.entity.Loan;
import com.example.hateoasdemo.entity.Payment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class CustomerService {

    private final CustomerDao customerRepository;

    private final PaymentDao paymentRepository;

    private final LoanDao loanRepository;

    public CustomerService(CustomerDao customerRepository, PaymentDao paymentRepository, LoanDao loanRepository) {
        this.customerRepository = customerRepository;
        this.paymentRepository = paymentRepository;
        this.loanRepository = loanRepository;
    }


    public Page<Customer> fetchCustomerDataAsPageWithSorting(int page, int pageSize, List<String> sortList, String sortOrder) {
        int size = pageSize == 0 ? Integer.MAX_VALUE : pageSize;
        Pageable pageable = PageRequest.of(page, size, Sort.by(createSortOrder(sortList, sortOrder)));
        return customerRepository.findAll(pageable);
    }


    public Page<Payment> fetchPaymentDataAsPageWithSorting(int page, int pageSize, List<String> sortList, String sortOrder) {
        int size = pageSize == 0 ? Integer.MAX_VALUE : pageSize;
        Pageable pageable = PageRequest.of(page, size, Sort.by(createSortOrder(sortList, sortOrder)));
        return paymentRepository.findByLoanLoanId(1,pageable);
    }

    public void saveLoandata(){
        Loan loan = new Loan();
        loan.setLoanId(1);
        loan.setAccountId("acoount1");

        loanRepository.save(loan);
    }

    public void savepaymentData(){
        Payment p1 =new Payment();
        Payment p2 =new Payment();
        Payment p3 =new Payment();
        Payment p4 =new Payment();
        Payment p5 =new Payment();
        Payment p6 =new Payment();
        Payment p7 =new Payment();
        p1.setCollateralAmount(1);
        p1.setLoanAmount(1);
        p2.setCollateralAmount(2);
        p2.setLoanAmount(2);
        p3.setCollateralAmount(3);
        p3.setLoanAmount(3);
        p4.setCollateralAmount(4);
        p4.setLoanAmount(4);
        p5.setCollateralAmount(5);
        p5.setLoanAmount(5);
        p6.setCollateralAmount(6);
        p6.setLoanAmount(6);
        p7.setCollateralAmount(7);
        p7.setLoanAmount(7);
        Optional<Loan> response = loanRepository.findByLoanId(1);
        p1.setLoan(response.get());
        p1.setLoan(response.get());
        p2.setLoan(response.get());
        p3.setLoan(response.get());
        p4.setLoan(response.get());p7.setLoan(response.get());
        p5.setLoan(response.get());
        p6.setLoan(response.get());

        paymentRepository.save(p1);
        paymentRepository.save(p2);
        paymentRepository.save(p3);
        paymentRepository.save(p4);
        paymentRepository.save(p5);
        paymentRepository.save(p6);
        paymentRepository.save(p7);

    }

    public void findAllData(){
        List<Loan> response = loanRepository.findAll();
        System.out.println("logger"+response.get(0).toString());

    }


    private List<Sort.Order> createSortOrder(List<String> sortList, String sortDirection) {
        List<Sort.Order> sorts = new ArrayList<>();
        Sort.Direction direction;
        for (String sort : sortList) {
            if (sortDirection != null) {
                direction = Sort.Direction.fromString(sortDirection);
            } else {
                direction = Sort.Direction.DESC;
            }
            sorts.add(new Sort.Order(direction, sort));
        }
        return sorts;
    }

}

