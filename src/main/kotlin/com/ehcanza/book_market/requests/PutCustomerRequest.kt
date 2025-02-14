package com.ehcanza.book_market.requests

import com.ehcanza.book_market.enums.CustomerStatus

data class PutCustomerRequest(
    var name: String?,
    var email: String?,
    var status: CustomerStatus?
)