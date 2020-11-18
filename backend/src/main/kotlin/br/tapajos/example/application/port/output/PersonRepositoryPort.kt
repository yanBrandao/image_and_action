package br.tapajos.example.application.port.output

import br.tapajos.example.application.domain.People
import br.tapajos.example.application.domain.Person

interface PersonRepositoryPort: GenericRepositoryPort<Person> {
    fun findNotUsedPerson(): People
}