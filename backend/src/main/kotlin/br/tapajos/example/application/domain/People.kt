package br.tapajos.example.application.domain

import br.tapajos.example.application.port.output.PersonRepositoryPort

class People(override val list: List<Person>): GroupPhrase<Person, PersonRepositoryPort>(list){
    override fun toString(): String {
        return "Person Phrases"
    }
}