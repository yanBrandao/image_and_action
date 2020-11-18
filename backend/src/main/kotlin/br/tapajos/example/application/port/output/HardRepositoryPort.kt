package br.tapajos.example.application.port.output

import br.tapajos.example.application.domain.Difficult
import br.tapajos.example.application.domain.Hard

interface HardRepositoryPort: GenericRepositoryPort<Hard> {
    fun findNotUsedHard(): Difficult
}