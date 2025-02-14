package com.ehcanza.book_market.extensions

import com.ehcanza.book_market.entities.Book
import com.ehcanza.book_market.entities.Customer
import com.ehcanza.book_market.enums.BookStatus
import com.ehcanza.book_market.enums.CustomerStatus
import com.ehcanza.book_market.requests.PostBookRequest
import com.ehcanza.book_market.requests.PostCustomerRequest
import com.ehcanza.book_market.requests.PutBookRequest
import com.ehcanza.book_market.requests.PutCustomerRequest

fun PostCustomerRequest.toCustomer(): Customer {
    return Customer(
        name = this.name,
        email = this.email,
        status = CustomerStatus.ATIVO
    )
}

fun PutCustomerRequest.toCustomer(customer: Customer): Customer {
    return Customer(
        id = customer.id,
        name = this.name ?: customer.name,
        email = this.email ?: customer.email,
        status = this.status ?: customer.status
    )
}

fun PostBookRequest.toBook(customer: Customer): Book {
    return Book(
        name = this.name,
        price = this.price,
        status = BookStatus.ATIVO,
        customer = customer
    )
}

fun PutBookRequest.toBook(book: Book): Book {
    return Book(
        id = book.id,
        name = this.name ?: book.name,
        price = this.price ?: book.price,
        status = book.status,
        customer = book.customer
    )
}