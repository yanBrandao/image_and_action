package br.tapajos.example.application.port.input

import br.tapajos.example.application.domain.Person

interface CreatePersonUseCase {
    fun execute(person: Person): Person
}