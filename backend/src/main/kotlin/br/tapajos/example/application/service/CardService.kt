package br.tapajos.example.application.service

import br.tapajos.example.application.domain.*
import br.tapajos.example.application.port.input.CreateCardUseCase
import br.tapajos.example.application.port.input.CreateRandomCardUseCase
import br.tapajos.example.application.port.input.GetByIdCardUseCase
import br.tapajos.example.application.port.output.*
import org.springframework.stereotype.Service

@Service
class CardService(
        private val cardRepositoryPort: CardRepositoryPort,
        private val personRepositoryPort: PersonRepositoryPort,
        private val hardRepositoryPort: HardRepositoryPort,
        private val mixRepositoryPort: MixRepositoryPort,
        private val objectRepositoryPort: ObjectRepositoryPort,
        private val funRepositoryPort: FunRepositoryPort,
        private val actionRepositoryPort: ActionRepositoryPort
) : CreateCardUseCase, CreateRandomCardUseCase, GetByIdCardUseCase {
    override fun execute(card: Card): Card {
        return cardRepositoryPort.save(card)
    }

    override fun execute(cardId: Long): Card {
        return cardRepositoryPort.findById(cardId)
    }

    override fun execute(isToSaveUsedCard: Boolean): Card {
        val people = personRepositoryPort.findNotUsedPerson()
        val difficult = hardRepositoryPort.findNotUsedHard()
        val actions = actionRepositoryPort.findNotUsedAction()
        val funnies = funRepositoryPort.findNotUsedFun()
        val objects = objectRepositoryPort.findNotUsedObject()
        val mixes = mixRepositoryPort.findNotUsedMix()

        val person = people.getRandom(personRepositoryPort, isToSaveUsedCard)?: Person()

        val hard = difficult.getRandom(hardRepositoryPort, isToSaveUsedCard)?: Hard()

        val action = actions.getRandom(actionRepositoryPort, isToSaveUsedCard)?: Action()

        val mix = mixes.getRandom(mixRepositoryPort, isToSaveUsedCard)?: Mix()

        val funn = funnies.getRandom(funRepositoryPort, isToSaveUsedCard)?: Fun()

        val objectt = objects.getRandom(objectRepositoryPort, isToSaveUsedCard)?: Objectt()

        return Card(
                personWord = person.name,
                actionWord = action.name,
                hardWord = hard.name,
                mixWord = mix.name,
                funWord = funn.name,
                objectWord = objectt.name
        )
    }


}