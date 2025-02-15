package com.ehcanza.book_market.response

import com.ehcanza.book_market.enums.CustomerStatus

data class CustomerResponse(
    var id: Long? = null,
    var name: String,
    var email: String,
    var status: CustomerStatus
)