package com.ehcanza.book_market.controllers

import com.ehcanza.book_market.entities.Book
import com.ehcanza.book_market.enums.BookStatus
import com.ehcanza.book_market.extensions.toBook
import com.ehcanza.book_market.requests.PostBookRequest
import com.ehcanza.book_market.requests.PutBookRequest
import com.ehcanza.book_market.services.BookService
import com.ehcanza.book_market.services.CustomerService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/books")
class BookController(
    val bookService: BookService,
    val customerService: CustomerService
) {

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): Book =
        bookService.findById(id)

    @GetMapping
    fun findAll(@RequestParam status: BookStatus?): List<Book> =
        bookService.findAll(status)

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun insert(@RequestBody book: PostBookRequest) {
        val customer = customerService.findById(book.customerId)
        bookService.insert(book.toBook(customer))
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun update(@PathVariable id: Long, @RequestBody book: PutBookRequest) {
        val bookFromDB = bookService.findById(id)
        bookService.update(book.toBook(bookFromDB))
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete(@PathVariable id: Long) =
        bookService.delete(id)

}