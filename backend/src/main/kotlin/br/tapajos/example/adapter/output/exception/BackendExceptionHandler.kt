package br.tapajos.example.adapter.output.exception

import org.springframework.http.HttpStatus.*
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.WebRequest
import tapajos.webservice.starter.commons.logger.logger
import java.lang.RuntimeException
import javax.persistence.EntityNotFoundException

@ControllerAdvice
class BackendExceptionHandler {

    val logger = logger<BackendExceptionHandler>()

    @ExceptionHandler(EntityNotFoundException::class)
    fun handleNotFoundEntity(
            entityNotFoundException: EntityNotFoundException,
            webRequest: WebRequest
    ): ResponseEntity<ErrorMessage> {
        return ResponseEntity(
                ErrorMessage(
                        entityNotFoundException.message.toString(),
                        NOT_FOUND.value().toString()
                ),
                NOT_FOUND
        )
    }

    @ExceptionHandler(RuntimeException::class)
    fun handleSQLException(exception: RuntimeException): ResponseEntity<ErrorMessage> {
        return ResponseEntity(
                ErrorMessage(
                        exception.message.toString(),
                        UNPROCESSABLE_ENTITY.value().toString()
                ),
                UNPROCESSABLE_ENTITY
        )
    }
}