package com.ehcanza.book_market.repositories

import com.ehcanza.book_market.entities.Book
import com.ehcanza.book_market.entities.Customer
import com.ehcanza.book_market.enums.BookStatus
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository

interface BookRepository : JpaRepository<Book, Long> {

    fun findByStatus(pageable: Pageable, status: BookStatus): Page<Book>
    fun findByCustomer(customer: Customer): List<Book>

}