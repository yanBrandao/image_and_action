package br.tapajos.example.application.domain

import br.tapajos.example.application.port.output.ObjectRepositoryPort
import tapajos.webservice.starter.commons.logger.logger
import java.lang.Exception
import java.util.*

class Objects(override val list: List<Objectt>): GroupPhrase<Objectt, ObjectRepositoryPort>(list){
    override fun toString(): String {
        return "Object Phrases"
    }
}