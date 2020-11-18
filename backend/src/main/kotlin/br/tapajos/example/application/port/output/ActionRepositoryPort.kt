package br.tapajos.example.application.port.output

import br.tapajos.example.application.domain.Action
import br.tapajos.example.application.domain.Actions

interface ActionRepositoryPort: GenericRepositoryPort<Action> {
    fun findNotUsedAction(): Actions
}