package com.ehcanza.book_market.services

import com.ehcanza.book_market.entities.Customer
import com.ehcanza.book_market.repositories.CustomerRepository
import org.springframework.stereotype.Service

@Service
class CustomerService(
    val repository: CustomerRepository
) {

    fun findById(id: Long): Customer {
        return repository.findById(id).orElseThrow()
    }

    fun findAll(name: String?): List<Customer> {
        name?.let {
            return repository.findByNameContaining(it)
        }
        return repository.findAll()
    }

    fun insert(customer: Customer) {
        repository.save(customer)
    }

    fun update(customer: Customer) {
        if(!repository.existsById(customer.id!!)) {
            throw Exception()
        }
        repository.save(customer)
    }

    fun delete(id: Long) {
        if(!repository.existsById(id)) {
            throw Exception()
        }
        repository.deleteById(id)
    }

}