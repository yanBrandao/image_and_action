package br.tapajos.example.application.service

import br.tapajos.example.application.domain.Card
import br.tapajos.example.application.port.input.CreateCardUseCase
import br.tapajos.example.application.port.input.GetByIdCardUseCase
import br.tapajos.example.application.port.output.CardRepositoryPort
import org.springframework.stereotype.Service

@Service
class CardService(
        private val cardRepositoryPort: CardRepositoryPort
) : CreateCardUseCase, GetByIdCardUseCase {
    override fun execute(card: Card): Card {
        return cardRepositoryPort.save(card)
    }

    override fun execute(cardId: Long): Card {
        return cardRepositoryPort.findById(cardId)
    }


}