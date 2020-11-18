package br.tapajos.example.adapter.output.repository

import br.tapajos.example.adapter.output.repository.jpa.PersonRepositoryJPA
import br.tapajos.example.application.domain.People
import br.tapajos.example.application.domain.Person
import br.tapajos.example.application.port.output.PersonRepositoryPort
import org.springframework.stereotype.Component

@Component
class PersonRepository(
        val personRepositoryJPA: PersonRepositoryJPA
): PersonRepositoryPort {
    override fun save(domain: Person): Person {
        return personRepositoryJPA.save(domain)
    }

    override fun findNotUsedPerson(): People {
        val list = personRepositoryJPA.findNotUsedPerson()
        return People(list)
    }
}