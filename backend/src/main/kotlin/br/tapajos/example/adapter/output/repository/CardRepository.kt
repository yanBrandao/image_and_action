package br.tapajos.example.adapter.output.repository

import br.tapajos.example.adapter.output.repository.jpa.CardRepositoryJPA
import br.tapajos.example.application.domain.Card
import br.tapajos.example.application.port.output.CardRepositoryPort
import org.springframework.stereotype.Service

@Service
class CardRepository(private val cardRepositoryJPA: CardRepositoryJPA): CardRepositoryPort{
    override fun save(card: Card): Card {
        return cardRepositoryJPA.save(card)
    }

    override fun findById(cardId: Long): Card {
        return cardRepositoryJPA.getOne(cardId)
    }
}