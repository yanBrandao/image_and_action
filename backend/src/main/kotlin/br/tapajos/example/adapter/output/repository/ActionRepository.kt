package br.tapajos.example.adapter.output.repository

import br.tapajos.example.adapter.output.repository.jpa.ActionRepositoryJPA
import br.tapajos.example.adapter.output.repository.jpa.PersonRepositoryJPA
import br.tapajos.example.application.domain.Action
import br.tapajos.example.application.domain.Actions
import br.tapajos.example.application.domain.People
import br.tapajos.example.application.domain.Person
import br.tapajos.example.application.port.output.ActionRepositoryPort
import br.tapajos.example.application.port.output.PersonRepositoryPort
import org.springframework.stereotype.Component

@Component
class ActionRepository(
        val actionRepositoryJPA: ActionRepositoryJPA
): ActionRepositoryPort {
    override fun save(domain: Action): Action {
        return actionRepositoryJPA.save(domain)
    }

    override fun findNotUsedAction(): Actions {
        val list = actionRepositoryJPA.findNotUsedAction()
        return Actions(list)
    }
}