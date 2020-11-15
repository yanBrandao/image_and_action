package br.tapajos.example.adapter.input.web.controller

import br.tapajos.example.adapter.input.web.api.CardAPI
import br.tapajos.example.adapter.input.web.api.request.CardRequest
import br.tapajos.example.adapter.input.web.api.response.CardIdResponse
import br.tapajos.example.adapter.input.web.api.response.CardResponse
import br.tapajos.example.adapter.input.web.converter.toDomain
import br.tapajos.example.adapter.input.web.converter.toResponse
import br.tapajos.example.adapter.input.web.converter.toResponseId
import br.tapajos.example.application.port.input.CreateCardUseCase
import br.tapajos.example.application.port.input.GetByIdCardUseCase
import net.logstash.logback.argument.StructuredArguments.kv
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.RestController
import tapajos.webservice.starter.commons.extension.objectToJson
import tapajos.webservice.starter.commons.logger.logger

@RestController
class CardController(
        private val createCardUseCase: CreateCardUseCase,
        private val getByIdCardUseCase: GetByIdCardUseCase
): CardAPI {
    private val logger = logger<CardController>()
    override fun card(cardRequest: CardRequest): CardIdResponse {
        logger.info("Starting request to generate a new Card with values [{}]",
                kv("card", cardRequest.objectToJson())
        )
        val card = createCardUseCase.execute(cardRequest.toDomain())
        logger.info("Responding successfully the request with [{}]",
                kv("card_id", card.id)
        )
        return card.toResponseId()
    }

    override fun getCard(cardId: Long): CardResponse {
        logger.info("Starting request to get Card with id [{}]",
                kv("card_id", cardId)
        )
        val card = getByIdCardUseCase.execute(cardId)
        logger.info("Responding successfully the request with [{}]",
                kv("card_id", card.id)
        )
        return card.toResponse()
    }
}