package br.tapajos.example.application.port.output

import br.tapajos.example.application.domain.Mix
import br.tapajos.example.application.domain.Mixes

interface MixRepositoryPort: GenericRepositoryPort<Mix> {
    fun findNotUsedMix(): Mixes
}