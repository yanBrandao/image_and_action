package br.tapajos.example.application.port.input

import br.tapajos.example.application.domain.Hard

interface CreateHardUseCase {
    fun execute(hard: Hard): Hard
}