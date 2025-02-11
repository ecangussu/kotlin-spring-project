package com.ehcanza.book_market.controllers

import com.ehcanza.book_market.entities.Customer
import com.ehcanza.book_market.extensions.toCustomer
import com.ehcanza.book_market.requests.PostCustomerRequest
import com.ehcanza.book_market.requests.PutCustomerRequest
import com.ehcanza.book_market.services.CustomerService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/customers")
class CustomerController(
    val service: CustomerService
) {

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): Customer {
        return service.findById(id)
    }

    @GetMapping
    fun findAll(@RequestParam name: String?): List<Customer> {
        return service.findAll(name)
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun insert(@RequestBody customer: PostCustomerRequest) {
        service.insert(customer.toCustomer())
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun update(@PathVariable id: Long, @RequestBody customer: PutCustomerRequest) {
        service.update(customer.toCustomer(id))
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete(@PathVariable id: Long) {
        service.delete(id)
    }

}