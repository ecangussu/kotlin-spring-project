package com.ehcanza.book_market.extensions

import com.ehcanza.book_market.entities.Book
import com.ehcanza.book_market.entities.Customer
import com.ehcanza.book_market.enums.BookStatus
import com.ehcanza.book_market.requests.PostBookRequest
import com.ehcanza.book_market.requests.PostCustomerRequest
import com.ehcanza.book_market.requests.PutBookRequest
import com.ehcanza.book_market.requests.PutCustomerRequest

fun PostCustomerRequest.toCustomer(): Customer {
    return Customer(name = this.name, email = this.email)
}

fun PutCustomerRequest.toCustomer(id: Long): Customer {
    return Customer(id = id, name = this.name, email = this.email)
}

fun PostBookRequest.toBook(customer: Customer): Book {
    return Book(name = this.name, price = this.price, status = BookStatus.ATIVO, customer = customer)
}

fun PutBookRequest.toBook(id: Long): Book {
    return Book(id = id, name = this.name, price = this.price)
}