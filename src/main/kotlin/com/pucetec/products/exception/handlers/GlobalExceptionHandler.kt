package com.pucetec.products.exception.handlers

import com.pucetec.products.exception.ProductAlreadyExistsException
import com.pucetec.products.exception.StockOutOfRangeException
import com.pucetec.products.models.responses.ErrorResponse
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice


@RestControllerAdvice
class GlobalExceptionHandler {


    @ExceptionHandler(StockOutOfRangeException::class)
    fun handleStockOutOfRangeException(
        ex: StockOutOfRangeException
    ): ResponseEntity<ErrorResponse>{
        return ResponseEntity(
            ErrorResponse(ex.message),
            HttpStatus.BAD_REQUEST
        )
    }

    @ExceptionHandler(ProductAlreadyExistsException::class)
    fun handleProductAlreadyExistsException(
        ex: ProductAlreadyExistsException
    ): ResponseEntity<ErrorResponse>{
        return ResponseEntity(
            ErrorResponse(ex.message),
            HttpStatus.BAD_REQUEST
        )
    }
}