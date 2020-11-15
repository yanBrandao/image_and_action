package br.tapajos.example.application.port.input

import br.tapajos.example.application.domain.Card

interface CreateCardUseCase {
    fun execute(card: Card): Card
}