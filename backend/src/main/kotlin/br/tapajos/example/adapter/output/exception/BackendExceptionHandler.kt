package br.tapajos.example.adapter.output.exception

import org.springframework.http.HttpStatus.NOT_FOUND
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.WebRequest
import javax.persistence.EntityNotFoundException

@ControllerAdvice
class BackendExceptionHandler {

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
}