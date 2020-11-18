package br.tapajos.example.adapter.input.web.controller

import br.tapajos.example.adapter.input.web.api.ActionAPI
import br.tapajos.example.adapter.input.web.api.request.ActionRequest
import br.tapajos.example.adapter.input.web.api.response.ActionResponse
import br.tapajos.example.adapter.input.web.converter.toDomain
import br.tapajos.example.adapter.input.web.converter.toResponse
import br.tapajos.example.application.port.input.CreateActionUseCase
import net.logstash.logback.argument.StructuredArguments
import org.springframework.web.bind.annotation.RestController
import tapajos.webservice.starter.commons.extension.objectToJson
import tapajos.webservice.starter.commons.logger.logger

@RestController
class ActionController(
        val createActionUseCase: CreateActionUseCase
): ActionAPI {
    private val logger = logger<ActionController>()
    override fun action(actionRequest: ActionRequest): ActionResponse {
        logger.info("Starting request to generate a new object with values [{}]",
                StructuredArguments.kv("action", actionRequest.objectToJson())
        )
        val action = createActionUseCase.execute(actionRequest.toDomain())
        logger.info("Responding successfully the request with [{}]",
                StructuredArguments.kv("action_id", action.id)
        )
        return action.toResponse()
    }

    override fun getAction(actionId: Long): ActionResponse {
        TODO("Not yet implemented")
    }
}