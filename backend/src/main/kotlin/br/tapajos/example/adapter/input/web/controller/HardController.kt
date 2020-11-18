package br.tapajos.example.adapter.input.web.controller

import br.tapajos.example.adapter.input.web.api.HardAPI
import br.tapajos.example.adapter.input.web.api.request.HardRequest
import br.tapajos.example.adapter.input.web.api.response.HardResponse
import br.tapajos.example.adapter.input.web.converter.toDomain
import br.tapajos.example.adapter.input.web.converter.toResponse
import br.tapajos.example.application.port.input.CreateHardUseCase
import net.logstash.logback.argument.StructuredArguments
import org.springframework.web.bind.annotation.RestController
import tapajos.webservice.starter.commons.extension.objectToJson
import tapajos.webservice.starter.commons.logger.logger

@RestController
class HardController(
        val createHardUseCase: CreateHardUseCase
): HardAPI {
    private val logger = logger<HardController>()
    override fun hard(hardRequest: HardRequest): HardResponse {
    logger.info("Starting request to generate a new Hard with values [{}]",
    StructuredArguments.kv("hard", hardRequest.objectToJson())
        )
        val hard = createHardUseCase.execute(hardRequest.toDomain())
        logger.info("Responding successfully the request with [{}]",
                StructuredArguments.kv("hard_id", hard.id)
        )
        return hard.toResponse()
    }

    override fun getHard(hardId: Long): HardResponse {
        TODO("Not yet implemented")
    }


}