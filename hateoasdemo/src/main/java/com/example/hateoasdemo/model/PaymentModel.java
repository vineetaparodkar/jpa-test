package com.example.hateoasdemo.model;

import org.springframework.hateoas.RepresentationModel;

public class PaymentModel extends RepresentationModel<PaymentModel> {
    private Long id;
    private int collateralAmount;
    private int loanAmount;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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


}
