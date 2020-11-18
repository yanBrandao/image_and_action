package br.tapajos.example.application.port.input

import br.tapajos.example.application.domain.Objectt

interface CreateObjectsUseCase {
    fun execute(objectt: Objectt): Objectt
}