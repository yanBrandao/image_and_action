package br.tapajos.example.adapter.output.repository

import br.tapajos.example.adapter.output.repository.jpa.FunRepositoryJPA
import br.tapajos.example.adapter.output.repository.jpa.PersonRepositoryJPA
import br.tapajos.example.application.domain.Fun
import br.tapajos.example.application.domain.Funnies
import br.tapajos.example.application.domain.People
import br.tapajos.example.application.domain.Person
import br.tapajos.example.application.port.output.FunRepositoryPort
import br.tapajos.example.application.port.output.PersonRepositoryPort
import org.springframework.stereotype.Component

@Component
class FunRepository(
        val  funRepositoryJPA: FunRepositoryJPA
): FunRepositoryPort {
    override fun save(domain: Fun): Fun {
        return funRepositoryJPA.save(domain)
    }

    override fun findNotUsedFun(): Funnies {
        val funnies = funRepositoryJPA.findNotUsedFun()
        return Funnies(funnies)
    }
}