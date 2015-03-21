package com.ofg.reports.model.entities;

import java.math.BigDecimal;

import javax.persistence.Entity;

import org.springframework.data.jpa.domain.AbstractPersistable;

import com.ofg.reports.model.LoanApplicationDto;

/**
 * @author mzielinski on 21.03.15.
 */
@Entity
public class LoanApplication extends AbstractPersistable<Long> {

    public LoanApplication() {
    }

    public LoanApplication(LoanApplicationDto dto) {
        job = dto.getJob();
        amount = dto.getAmount();
        fraudStatus = dto.getFraudStatus();
        decision = dto.getDecision();
        loanId = dto.getLoanId();
    }

    private String job;
    private String loanId;
    private BigDecimal amount;
    private String fraudStatus;
    private String decision;

    public String getLoanId() {
        return loanId;
    }

    public void setLoanId(String loanId) {
        this.loanId = loanId;
    }

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

    @Override
    public String toString() {
        return "LoanApplication{" +
                "job='" + job + '\'' +
                ", loanId='" + loanId + '\'' +
                ", amount=" + amount +
                ", fraudStatus='" + fraudStatus + '\'' +
                ", decision='" + decision + '\'' +
                '}';
    }

}
