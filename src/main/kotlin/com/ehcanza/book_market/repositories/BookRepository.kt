package com.ehcanza.book_market.repositories

import com.ehcanza.book_market.entities.Book
import org.springframework.data.jpa.repository.JpaRepository

interface BookRepository : JpaRepository<Book, Long> {

    fun findByNameContaining(name: String): List<Book>

}