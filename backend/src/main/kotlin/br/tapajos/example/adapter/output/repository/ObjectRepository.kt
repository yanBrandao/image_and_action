package br.tapajos.example.adapter.output.repository

import br.tapajos.example.adapter.output.repository.jpa.ObjectRepositoryJPA
import br.tapajos.example.application.domain.Objects
import br.tapajos.example.application.domain.Objectt
import br.tapajos.example.application.port.output.ObjectRepositoryPort
import org.springframework.stereotype.Component

@Component
class ObjectRepository(
        val objectRepositoryJPA: ObjectRepositoryJPA
): ObjectRepositoryPort {
    override fun save(domain: Objectt): Objectt {
        return objectRepositoryJPA.save(domain)
    }

    override fun findNotUsedObject(): Objects {
        val list = objectRepositoryJPA.findNotUsedObject()
        return Objects(list)
    }
}