package br.tapajos.example.application.port.output

import br.tapajos.example.application.domain.Objects
import br.tapajos.example.application.domain.Objectt

interface ObjectRepositoryPort: GenericRepositoryPort<Objectt>{
    fun findNotUsedObject(): Objects
}