package com.ofg.reports.repository

import com.ofg.reports.model.entities.Client
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

/**
 * @author mzielinski on 21.03.15.
 */
@Repository
interface ClientRepository extends CrudRepository<Client, Long> {
}
