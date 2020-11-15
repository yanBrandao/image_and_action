package br.tapajos.example.adapter.input.web.converter

import br.tapajos.example.adapter.input.web.api.request.CardRequest
import br.tapajos.example.adapter.input.web.api.response.CardIdResponse
import br.tapajos.example.adapter.input.web.api.response.CardResponse
import br.tapajos.example.application.domain.Card

fun CardRequest.toDomain(): Card =
        Card(
                hardWord = this.hardWord,
                actionWord = this.actionWord,
                mixWord = this.mixWord,
                objectWord = this.objectWord,
                peopleWord = this.peopleWord
        )

fun Card.toResponseId(): CardIdResponse =
        CardIdResponse(this.id)

fun Card.toResponse(): CardResponse =
        CardResponse(
                hardWord = this.hardWord,
                actionWord = this.actionWord,
                mixWord = this.mixWord,
                objectWord = this.objectWord,
                peopleWord = this.peopleWord
        )