package com.ehcanza.book_market.services

import com.ehcanza.book_market.entities.Book
import com.ehcanza.book_market.entities.Customer
import com.ehcanza.book_market.enums.BookStatus
import com.ehcanza.book_market.repositories.BookRepository
import org.springframework.stereotype.Service

@Service
class BookService(
    val repository: BookRepository
) {

    fun findById(id: Long): Book {
        return repository.findById(id).orElseThrow()
    }

    fun findAll(status: BookStatus?): List<Book> {
        status?.let {
            return repository.findByStatus(status)
        }
        return repository.findAll()
    }

    fun insert(book: Book) {
        repository.save(book)
    }

    fun update(book: Book) {
        repository.save(book)
    }

    fun delete(id: Long) {
        val book = findById(id)
        book.status = BookStatus.CANCELADO
        update(book)
    }

    fun deleteByCustomer(customer: Customer) {
        val books = repository.findByCustomer(customer)
        for(book in books) {
            book.status = BookStatus.DELETADO
        }
        repository.saveAll(books)
    }

}