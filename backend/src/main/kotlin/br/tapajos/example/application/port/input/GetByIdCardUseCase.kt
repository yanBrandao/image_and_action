package br.tapajos.example.application.port.input

import br.tapajos.example.application.domain.Card

interface GetByIdCardUseCase {
    fun execute(cardId: Long): Card
}