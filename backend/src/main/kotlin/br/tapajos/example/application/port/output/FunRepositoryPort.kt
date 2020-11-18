package br.tapajos.example.application.port.output

import br.tapajos.example.application.domain.Fun
import br.tapajos.example.application.domain.Funnies

interface FunRepositoryPort: GenericRepositoryPort<Fun> {
    fun findNotUsedFun(): Funnies
}