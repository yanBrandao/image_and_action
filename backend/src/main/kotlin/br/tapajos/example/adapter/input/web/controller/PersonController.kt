package br.tapajos.example.adapter.input.web.controller

import br.tapajos.example.adapter.input.web.api.PersonAPI
import br.tapajos.example.adapter.input.web.api.request.PersonRequest
import br.tapajos.example.adapter.input.web.api.response.PersonResponse
import br.tapajos.example.adapter.input.web.converter.toDomain
import br.tapajos.example.adapter.input.web.converter.toResponse
import br.tapajos.example.application.port.input.CreatePersonUseCase
import br.tapajos.example.application.port.input.UploadPersonUseCase
import net.logstash.logback.argument.StructuredArguments
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.multipart.MultipartFile
import tapajos.webservice.starter.commons.extension.objectToJson
import tapajos.webservice.starter.commons.logger.logger

@RestController
class PersonController(
        val createPersonUseCase: CreatePersonUseCase,
        val uploadPersonUseCase: UploadPersonUseCase
): PersonAPI {
    private val logger = logger<PersonController>()
    override fun person(personRequest: PersonRequest): PersonResponse {
        logger.info("Starting request to generate a new Person with values [{}]",
                StructuredArguments.kv("person", personRequest.objectToJson())
        )
        val person = createPersonUseCase.execute(personRequest.toDomain())
        logger.info("Responding successfully the request with [{}]",
                StructuredArguments.kv("person_id", person.id)
        )
        return person.toResponse()
    }

    override fun upload(file: MultipartFile) {
        uploadPersonUseCase.execute(file)
    }

    override fun getPerson(personId: Long): PersonResponse {
        TODO("Not yet implemented")
    }


}