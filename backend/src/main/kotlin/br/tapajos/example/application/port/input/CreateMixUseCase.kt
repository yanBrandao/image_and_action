package br.tapajos.example.application.port.input

import br.tapajos.example.application.domain.Mix

interface CreateMixUseCase {
    fun execute(mix: Mix): Mix
}