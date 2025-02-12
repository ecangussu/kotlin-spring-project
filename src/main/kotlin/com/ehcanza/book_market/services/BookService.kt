package com.ehcanza.book_market.services

import com.ehcanza.book_market.entities.Book
import com.ehcanza.book_market.repositories.BookRepository
import org.springframework.stereotype.Service

@Service
class BookService(
    val repository: BookRepository
) {

    fun findById(id: Long): Book {
        return repository.findById(id).orElseThrow()
    }

    fun findAll(name: String?): List<Book> {
        name?.let {
            return repository.findByNameContaining(it)
        }
        return repository.findAll()
    }

    fun insert(book: Book) {
        repository.save(book)
    }

    fun update(book: Book) {
        if(!repository.existsById(book.id!!)) {
            throw Exception()
        }
        repository.save(book)
    }

    fun delete(id: Long) {
        if(!repository.existsById(id)) {
            throw Exception()
        }
        repository.deleteById(id)
    }

}