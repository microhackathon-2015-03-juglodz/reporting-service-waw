package com.ofg.reports.model;

import java.math.BigDecimal;

import javax.persistence.Entity;

import org.springframework.data.jpa.domain.AbstractPersistable;

import com.ofg.reports.model.entities.Client;

/**
 * @author mzielinski on 21.03.15.
 */
public class LoanApplicationDto {

    private String job;
    private BigDecimal amount;
    private String fraudStatus;
    private String decision;
    private String loanId;

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getFraudStatus() {
        return fraudStatus;
    }

    public void setFraudStatus(String fraudStatus) {
        this.fraudStatus = fraudStatus;
    }

    public String getDecision() {
        return decision;
    }

    public void setDecision(String decision) {
        this.decision = decision;
    }

    public String getLoanId() {
        return loanId;
    }

    public void setLoanId(String loanId) {
        this.loanId = loanId;
    }

    @Override
    public String toString() {
        return "LoanApplicationDto{" +
                "job='" + job + '\'' +
                ", amount=" + amount +
                ", fraudStatus='" + fraudStatus + '\'' +
                ", decision='" + decision + '\'' +
                ", loanId='" + loanId + '\'' +
                '}';
    }

}
