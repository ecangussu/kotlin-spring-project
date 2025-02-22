package com.ehcanza.book_market.controllers

import com.ehcanza.book_market.extensions.toCustomer
import com.ehcanza.book_market.extensions.toResponse
import com.ehcanza.book_market.requests.PostCustomerRequest
import com.ehcanza.book_market.requests.PutCustomerRequest
import com.ehcanza.book_market.response.CustomerResponse
import com.ehcanza.book_market.services.CustomerService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/customers")
class CustomerController(
    val service: CustomerService
) {

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): CustomerResponse {
        return service.findById(id).toResponse()
    }

    @GetMapping
    fun findAll(@RequestParam name: String?): List<CustomerResponse> {
        return service.findAll(name).map { it.toResponse() }
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun insert(@RequestBody @Valid customer: PostCustomerRequest) {
        service.insert(customer.toCustomer())
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun update(@PathVariable id: Long, @RequestBody customer: PutCustomerRequest) {
        val customerFromDB = service.findById(id)
        service.update(customer.toCustomer(customerFromDB))
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete(@PathVariable id: Long) {
        service.delete(id)
    }

}