package br.tapajos.example.adapter.input.web.controller

import br.tapajos.example.adapter.input.web.api.ObjectAPI
import br.tapajos.example.adapter.input.web.api.request.ObjectRequest
import br.tapajos.example.adapter.input.web.api.response.ObjectResponse
import br.tapajos.example.adapter.input.web.converter.toDomain
import br.tapajos.example.adapter.input.web.converter.toResponse
import br.tapajos.example.application.port.input.CreateObjectsUseCase
import net.logstash.logback.argument.StructuredArguments
import org.springframework.web.bind.annotation.RestController
import tapajos.webservice.starter.commons.extension.objectToJson
import tapajos.webservice.starter.commons.logger.logger

@RestController
class ObjectController(
        val createObjectsUseCase: CreateObjectsUseCase
): ObjectAPI {
    private val logger = logger<ObjectController>()
    override fun objectt(objectRequest: ObjectRequest): ObjectResponse {
        logger.info("Starting request to generate a new object with values [{}]",
                StructuredArguments.kv("object", objectRequest.objectToJson())
        )
        val objectt = createObjectsUseCase.execute(objectRequest.toDomain())
        logger.info("Responding successfully the request with [{}]",
                StructuredArguments.kv("object_id", objectt.id)
        )
        return objectt.toResponse()
    }

    override fun getObject(objectId: Long): ObjectResponse {
        TODO("Not yet implemented")
    }
}