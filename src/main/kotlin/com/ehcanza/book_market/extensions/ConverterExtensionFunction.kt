package com.ehcanza.book_market.extensions

import com.ehcanza.book_market.entities.Customer
import com.ehcanza.book_market.requests.PostCustomerRequest
import com.ehcanza.book_market.requests.PutCustomerRequest

fun PostCustomerRequest.toCustomer(): Customer {
    return Customer(name = this.name, email = this.email)
}

fun PutCustomerRequest.toCustomer(id: Long): Customer {
    return Customer(id = id, name = this.name, email = this.email)
}