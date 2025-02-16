package com.ehcanza.book_market.exceptions

class BadRequestException(
    override val message: String,
    val errorCode: String
): Exception() {}