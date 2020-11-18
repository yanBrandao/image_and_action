package br.tapajos.example.adapter.input.web.converter

import br.tapajos.example.adapter.input.web.api.request.*
import br.tapajos.example.adapter.input.web.api.response.*
import br.tapajos.example.application.domain.*

fun CardRequest.toDomain(): Card =
        Card(
                hardWord = this.hardWord,
                actionWord = this.actionWord,
                mixWord = this.mixWord,
                objectWord = this.objectWord,
                personWord = this.personWord,
                funWord = this.funWord
        )

fun Card.toResponseId(): CardIdResponse =
        CardIdResponse(this.id)

fun Card.toResponse(): CardResponse =
        CardResponse(
                hardWord = this.hardWord,
                actionWord = this.actionWord,
                mixWord = this.mixWord,
                objectWord = this.objectWord,
                personWord = this.personWord,
                funWord = this.funWord
        )

fun PersonRequest.toDomain(): Person =
        Person(
                name = this.name
        )

fun Person.toResponse(): PersonResponse =
        PersonResponse(
                id = this.id,
                name = this.name,
                used = this.used
        )

fun MixRequest.toDomain(): Mix =
        Mix(
                name = this.name
        )

fun Mix.toResponse(): MixResponse =
        MixResponse(
                id = this.id,
                name = this.name,
                used = this.used
        )

fun FunRequest.toDomain(): Fun =
        Fun(
                name = this.name
        )

fun Fun.toResponse(): FunResponse =
        FunResponse(
                id = this.id,
                name = this.name,
                used = this.used
        )

fun HardRequest.toDomain(): Hard =
        Hard(
                name = this.name
        )

fun Hard.toResponse(): HardResponse =
        HardResponse(
                id = this.id,
                name = this.name,
                used = this.used
        )

fun ActionRequest.toDomain(): Action =
        Action(
                name = this.name
        )

fun Action.toResponse(): ActionResponse =
        ActionResponse(
                id = this.id,
                name = this.name,
                used = this.used
        )

fun ObjectRequest.toDomain(): Objectt =
        Objectt(
                name = this.name
        )

fun Objectt.toResponse(): ObjectResponse =
        ObjectResponse(
                id = this.id,
                name = this.name,
                used = this.used
        )
