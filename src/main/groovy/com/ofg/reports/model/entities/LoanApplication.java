package com.ofg.reports.model.entities;

import com.ofg.reports.model.LoanApplicationDto;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;

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
    private Client client;

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

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
