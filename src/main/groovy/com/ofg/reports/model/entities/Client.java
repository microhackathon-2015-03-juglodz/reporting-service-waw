package com.ofg.reports.model.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import com.ofg.reports.model.ClientDto;
import com.ofg.reports.model.LoanApplicationDto;
import org.springframework.data.jpa.domain.AbstractPersistable;

/**
 * @author mzielinski on 21.03.15.
 */
@Entity
public class Client extends AbstractPersistable<Long> {

    private String firstName;
    private String lastName;
    private int age;

    public Client() {
    }

    public Client(ClientDto dto) {
        firstName = dto.getFirstName();
        lastName = dto.getLastName();
        age = dto.getAge();
    }

    @OneToMany(targetEntity=LoanApplication.class, mappedBy="client", fetch= FetchType.EAGER)
    private List<LoanApplication> loan;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<LoanApplication> getLoan() {
        if (loan == null) {
            loan = new ArrayList<>();
        }
        return loan;
    }

    public void setLoan(List<LoanApplication> loan) {
        this.loan = loan;
    }
}
