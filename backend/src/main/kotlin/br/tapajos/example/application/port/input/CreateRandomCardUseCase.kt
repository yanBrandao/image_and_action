package br.tapajos.example.application.port.input

import br.tapajos.example.application.domain.Card

interface CreateRandomCardUseCase {
    fun execute(isToSaveUsedCard: Boolean): Card
}