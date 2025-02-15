package com.ehcanza.book_market.response

import com.ehcanza.book_market.entities.Customer
import com.ehcanza.book_market.enums.BookStatus
import java.math.BigDecimal

data class BookResponse(
    var id: Long? = null,
    var name: String,
    var price: BigDecimal,
    var customer: Customer? = null,
    var status: BookStatus? = null
)
