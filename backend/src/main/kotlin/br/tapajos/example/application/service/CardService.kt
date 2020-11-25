package br.tapajos.example.application.service

import br.tapajos.example.application.convert.toType
import br.tapajos.example.application.domain.*
import br.tapajos.example.application.port.input.CreateCardUseCase
import br.tapajos.example.application.port.input.CreateRandomCardUseCase
import br.tapajos.example.application.port.input.GetByIdCardUseCase
import br.tapajos.example.application.port.input.UploadPersonUseCase
import br.tapajos.example.application.port.output.*
import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile
import tapajos.webservice.starter.commons.logger.logger
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader

@Service
class CardService(
        private val cardRepositoryPort: CardRepositoryPort,
        private val personRepositoryPort: PersonRepositoryPort,
        private val hardRepositoryPort: HardRepositoryPort,
        private val mixRepositoryPort: MixRepositoryPort,
        private val objectRepositoryPort: ObjectRepositoryPort,
        private val funRepositoryPort: FunRepositoryPort,
        private val actionRepositoryPort: ActionRepositoryPort
) : CreateCardUseCase, CreateRandomCardUseCase, GetByIdCardUseCase, UploadPersonUseCase {
    val logger = logger<CardService>()

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

    override fun execute(file: MultipartFile) {
        val bytes = file.bytes
        var count = 0;
        val rows = String(bytes).split("\n")
        rows.forEach {
            val split = it.split(",")
            try {
                count ++
                logger.info("Saving ${split[0]} with category ${split[1]}")
                when (split[1].toType()) {
                    Type.F -> funRepositoryPort.save(Fun(name = split[0]))
                    Type.M -> mixRepositoryPort.save(Mix(name = split[0]))
                    Type.A -> actionRepositoryPort.save(Action(name = split[0]))
                    Type.O -> objectRepositoryPort.save(Objectt(name = split[0]))
                    Type.H -> hardRepositoryPort.save(Hard(name = split[0]))
                    Type.P -> personRepositoryPort.save(Person(name = split[0]))
                }
            } catch (ex: Exception) {
                count--
                logger.error("Could not add ${split[0]} cause of ${ex.message}")
            }
        }
        logger.info("Phrase(s) $count saved")
    }
}