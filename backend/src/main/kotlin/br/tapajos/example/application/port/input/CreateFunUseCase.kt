package br.tapajos.example.application.port.input

import br.tapajos.example.application.domain.Fun

interface CreateFunUseCase {
    fun execute(funn: Fun): Fun
}