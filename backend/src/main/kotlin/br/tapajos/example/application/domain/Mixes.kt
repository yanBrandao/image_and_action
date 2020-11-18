package br.tapajos.example.application.domain

import br.tapajos.example.application.port.output.MixRepositoryPort
import tapajos.webservice.starter.commons.logger.logger
import java.util.*

class Mixes(override val list: List<Mix>): GroupPhrase<Mix, MixRepositoryPort>(list){
    override fun toString(): String {
        return "Mix Phrases"
    }
}