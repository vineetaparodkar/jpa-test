package com.example.hateoasdemo.entity;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "loan")
public class Loan {

    @Id
    @Column(name ="loan_id")
    private int loanId;

    @Column(name ="account_id")
    private String accountId;

    @OneToMany(targetEntity = Payment.class,mappedBy = "loan", fetch = FetchType.LAZY, cascade=CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private List loanHistory;

    public List getLoanHistory() {
        return loanHistory;
    }

    public void setLoanHistory(List loanHistory) {
        this.loanHistory = loanHistory;
    }

    public int getLoanId() {
        return loanId;
    }

    public void setLoanId(int loanId) {
        this.loanId = loanId;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }


    @Override
    public String toString() {
        return "Loan{" +
                "loanId=" + loanId +
                ", accountId='" + accountId + '\'' +
                ", loanHistory=" + loanHistory +
                '}';
    }
}