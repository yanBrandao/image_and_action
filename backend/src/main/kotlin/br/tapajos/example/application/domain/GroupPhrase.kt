package br.tapajos.example.application.domain

import br.tapajos.example.application.port.output.GenericRepositoryPort
import tapajos.webservice.starter.commons.logger.logger
import java.util.*

abstract class GroupPhrase<D: Phrase, P: GenericRepositoryPort<D>>(open val list: List<D>) {
    private val logger = logger<GroupPhrase<D, P>>()

    fun getRandom(port: P, isToSaveUsedCard: Boolean): D? {
        val domain: D? = try {
            val randomIndex = Random().nextInt(this.list.size)
            this.list[randomIndex]
        } catch (ex: Exception) {
            logger.info("There's no $this not used. Returning empty!")
            null
        }
        if(isToSaveUsedCard && domain != null) {
            domain.used = true
            port.save(domain)
        }
        return domain
    }
}