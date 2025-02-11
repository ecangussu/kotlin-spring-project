package com.ehcanza.book_market.repositories

import com.ehcanza.book_market.entities.Customer
import org.springframework.data.jpa.repository.JpaRepository

interface CustomerRepository : JpaRepository<Customer, Long> {

    fun findByNameContaining(name: String): List<Customer>

}