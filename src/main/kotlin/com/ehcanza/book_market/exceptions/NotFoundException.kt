package com.ehcanza.book_market.exceptions

class NotFoundException(
    override val message: String,
    val errorCode: String
): Exception() {}