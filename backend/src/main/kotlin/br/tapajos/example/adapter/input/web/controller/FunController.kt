package br.tapajos.example.adapter.input.web.controller

import br.tapajos.example.adapter.input.web.api.FunAPI
import br.tapajos.example.adapter.input.web.api.request.FunRequest
import br.tapajos.example.adapter.input.web.api.response.FunResponse
import br.tapajos.example.adapter.input.web.converter.toDomain
import br.tapajos.example.adapter.input.web.converter.toResponse
import br.tapajos.example.application.port.input.CreateFunUseCase
import net.logstash.logback.argument.StructuredArguments
import org.springframework.web.bind.annotation.RestController
import tapajos.webservice.starter.commons.extension.objectToJson
import tapajos.webservice.starter.commons.logger.logger

@RestController
class FunController(
      val createFunUseCase: CreateFunUseCase
): FunAPI {
    private val logger = logger<FunController>()
    override fun funn(funRequest: FunRequest): FunResponse {
        logger.info("Starting request to generate a new Fun with values [{}]",
                StructuredArguments.kv("fun", funRequest.objectToJson())
        )
        val funn = createFunUseCase.execute(funRequest.toDomain())
        logger.info("Responding successfully the request with [{}]",
                StructuredArguments.kv("fun_id", funn.id)
        )
        return funn.toResponse()
    }

    override fun getFun(funId: Long): FunResponse {
        TODO("Not yet implemented")
    }


}