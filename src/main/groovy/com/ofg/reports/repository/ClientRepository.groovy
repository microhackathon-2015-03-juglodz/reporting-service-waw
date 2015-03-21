package com.ofg.reports.repository

import com.ofg.reports.model.entities.Client
import org.springframework.data.repository.CrudRepository

/**
 * @author mzielinski on 21.03.15.
 */
interface ClientRepository extends CrudRepository<Client, Long> {

    public Client findByLoanId(String loanId)

}
