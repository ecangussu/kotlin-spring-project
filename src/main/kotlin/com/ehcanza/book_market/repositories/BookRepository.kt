package com.ehcanza.book_market.repositories

import com.ehcanza.book_market.entities.Book
import com.ehcanza.book_market.entities.Customer
import com.ehcanza.book_market.enums.BookStatus
import org.springframework.data.jpa.repository.JpaRepository

interface BookRepository : JpaRepository<Book, Long> {

    fun findByStatus(status: BookStatus): List<Book>
    fun findByCustomer(customer: Customer): List<Book>

}