package com.ehcanza.book_market.exceptions

import com.ehcanza.book_market.enums.Errors
import com.ehcanza.book_market.response.ErrorResponse
import com.ehcanza.book_market.response.FieldErrorResponse
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.WebRequest

@ControllerAdvice
class ControllerAdvice{

    @ExceptionHandler(NotFoundException::class)
    fun handleNotFoundException(exception: NotFoundException, webRequest: WebRequest): ResponseEntity<ErrorResponse> {
        val error = ErrorResponse(
            HttpStatus.NOT_FOUND.value(),
            exception.message,
            exception.errorCode,
            null
        )

        return ResponseEntity(error, HttpStatus.NOT_FOUND)
    }

    @ExceptionHandler(BadRequestException::class)
    fun handleBadRequestException(exception: BadRequestException, webRequest: WebRequest): ResponseEntity<ErrorResponse> {
        val error = ErrorResponse(
            HttpStatus.BAD_REQUEST.value(),
            exception.message,
            exception.errorCode,
            null
        )

        return ResponseEntity(error, HttpStatus.BAD_REQUEST)
    }

    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun handleMethodArgumentNotValidException(exception: MethodArgumentNotValidException, webRequest: WebRequest): ResponseEntity<ErrorResponse> {
        val error = ErrorResponse(
            HttpStatus.UNPROCESSABLE_ENTITY.value(),
            Errors.BM0001.message,
            Errors.BM0001.code,
            exception.bindingResult.fieldErrors.map { FieldErrorResponse(it.defaultMessage ?: "Inválido", it.field) }
        )

        return ResponseEntity(error, HttpStatus.UNPROCESSABLE_ENTITY)
    }

}
