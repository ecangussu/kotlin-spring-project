package com.ehcanza.book_market.requests

import com.fasterxml.jackson.annotation.JsonAlias
import java.math.BigDecimal

data class PostBookRequest(
    var name: String,
    var price: BigDecimal,

    @JsonAlias("customer_id")
    var customerId: Long
)