package br.tapajos.example.adapter.input.web.controller

import br.tapajos.example.adapter.input.web.api.MixAPI
import br.tapajos.example.adapter.input.web.api.request.MixRequest
import br.tapajos.example.adapter.input.web.api.response.MixResponse
import br.tapajos.example.adapter.input.web.converter.toDomain
import br.tapajos.example.adapter.input.web.converter.toResponse
import br.tapajos.example.application.port.input.CreateMixUseCase
import net.logstash.logback.argument.StructuredArguments
import org.springframework.web.bind.annotation.RestController
import tapajos.webservice.starter.commons.extension.objectToJson
import tapajos.webservice.starter.commons.logger.logger

@RestController
class MixController(
        val createMixUseCase: CreateMixUseCase
): MixAPI {
    private val logger = logger<MixController>()
    override fun mix(mixRequest: MixRequest): MixResponse {
        logger.info("Starting request to generate a new Mix with values [{}]",
                StructuredArguments.kv("mix", mixRequest.objectToJson())
        )
        val mix = createMixUseCase.execute(mixRequest.toDomain())
        logger.info("Responding successfully the request with [{}]",
                StructuredArguments.kv("mix_id", mix.id)
        )
        return mix.toResponse()
    }

    override fun getMix(mixId: Long): MixResponse {
        TODO("Not yet implemented")
    }

}