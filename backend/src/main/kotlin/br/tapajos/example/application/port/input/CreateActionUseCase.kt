package br.tapajos.example.application.port.input

import br.tapajos.example.application.domain.Action

interface CreateActionUseCase {
    fun execute(action: Action): Action
}