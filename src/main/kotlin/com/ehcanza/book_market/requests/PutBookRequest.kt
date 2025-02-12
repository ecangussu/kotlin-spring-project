package com.ehcanza.book_market.requests

import java.math.BigDecimal

data class PutBookRequest(
    var name: String,
    var price: BigDecimal
)