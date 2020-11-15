package br.tapajos.example.application.port.output

import br.tapajos.example.application.domain.Card

interface CardRepositoryPort {
    fun save(card: Card): Card
    fun findById(cardId: Long): Card
}