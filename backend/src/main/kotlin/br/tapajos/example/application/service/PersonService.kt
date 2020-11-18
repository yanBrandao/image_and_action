package br.tapajos.example.application.service

import br.tapajos.example.application.domain.Person
import br.tapajos.example.application.port.input.CreatePersonUseCase
import br.tapajos.example.application.port.output.PersonRepositoryPort
import org.springframework.stereotype.Service

@Service
class PersonService(
    val personRepositoryPort: PersonRepositoryPort
): CreatePersonUseCase {
    override fun execute(person: Person): Person {
        return personRepositoryPort.save(person)
    }

}