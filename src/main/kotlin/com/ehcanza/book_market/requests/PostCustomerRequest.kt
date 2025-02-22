package com.ehcanza.book_market.requests

import com.ehcanza.book_market.validation.EmailAvailable
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotEmpty

data class PostCustomerRequest(

    @field:NotEmpty(message = "Nome deve ser informado")
    var name: String,

    @field:Email(message = "E-mail deve conter [@] e o domínio")
    @EmailAvailable
    var email: String

)