package com.ehcanza.book_market.services

import com.ehcanza.book_market.entities.Book
import com.ehcanza.book_market.entities.Customer
import com.ehcanza.book_market.enums.BookStatus
import com.ehcanza.book_market.enums.CustomerStatus
import com.ehcanza.book_market.repositories.BookRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class BookService(
    val repository: BookRepository
) {

    fun findById(id: Long): Book {
        return repository.findById(id).orElseThrow()
    }

    fun findAll(pageable: Pageable, status: BookStatus?): Page<Book> {
        status?.let {
            return repository.findByStatus(pageable, status)
        }
        return repository.findAll(pageable)
    }

    fun insert(book: Book) {
        if(book.customer?.status == CustomerStatus.INATIVO) {
            throw Exception("Não é possível vincular o livro a um cliente ${CustomerStatus.INATIVO}")
        }
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