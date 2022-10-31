package com.example.hateoasdemo.entity;

import javax.persistence.*;

@Entity
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    @Column(name = "collateral_amount")
    private int collateralAmount;

    @Column(name = "loan_amount")
    private int loanAmount;


    @ManyToOne(targetEntity = Loan.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "loan_loan_id")
    protected Loan loan;


    public Payment(int collateralAmount, int loanAmount) {
        super();
        this.collateralAmount = collateralAmount;
        this.loanAmount = loanAmount;

    }

    public Payment() {
        super();
        // TODO Auto-generated constructor stub
    }

    public Loan getLoan() {
        return loan;
    }

    public void setLoan(Loan loan) {
        this.loan = loan;
    }

    public int getCollateralAmount() {
        return collateralAmount;
    }

    public void setCollateralAmount(int collateralAmount) {
        this.collateralAmount = collateralAmount;
    }

    public int getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(int loanAmount) {
        this.loanAmount = loanAmount;
    }


    @Override
    public String toString() {
        return "Payment{" +
                "id=" + id +
                ", collateralAmount=" + collateralAmount +
                ", loanAmount=" + loanAmount +
                ", loan=" + loan +
                '}';
    }
}