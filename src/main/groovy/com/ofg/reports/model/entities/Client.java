package com.ofg.reports.model.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.springframework.data.jpa.domain.AbstractPersistable;

import com.ofg.reports.model.ClientDto;

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

    @OneToMany(cascade={CascadeType.ALL})
    @JoinColumn(name = "client_id")
    private List<LoanApplication> loan = new ArrayList<>();

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
        return loan;
    }

    public void setLoan(List<LoanApplication> loan) {
        this.loan = loan;
    }

    @Override
    public String toString() {
        return "Client{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", loan=" + loan +
                '}';
    }

}
