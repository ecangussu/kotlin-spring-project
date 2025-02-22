package com.ehcanza.book_market.services

import com.ehcanza.book_market.entities.Customer
import com.ehcanza.book_market.enums.CustomerStatus
import com.ehcanza.book_market.enums.Errors
import com.ehcanza.book_market.exceptions.NotFoundException
import com.ehcanza.book_market.repositories.CustomerRepository
import org.springframework.stereotype.Service

@Service
class CustomerService(
    val customerRepository: CustomerRepository,
    val bookService: BookService
) {

    fun findById(id: Long): Customer {
        return customerRepository.findById(id).orElseThrow { NotFoundException(Errors.BM2001.message.format(id), Errors.BM2001.code) }
    }

    fun findAll(name: String?): List<Customer> {
        name?.let {
            return customerRepository.findByNameContaining(it)
        }
        return customerRepository.findAll()
    }

    fun insert(customer: Customer) {
        customerRepository.save(customer)
    }

    fun update(customer: Customer) {
        if(!customerRepository.existsById(customer.id!!)) {
            throw Exception()
        }
        customerRepository.save(customer)
    }

    fun delete(id: Long) {
        val customer = findById(id)
        bookService.deleteByCustomer(customer)

        customer.status = CustomerStatus.INATIVO
        customerRepository.save(customer)
    }

    fun emailAvailable(email: String): Boolean {
        return !customerRepository.existsByEmail(email)
    }

}