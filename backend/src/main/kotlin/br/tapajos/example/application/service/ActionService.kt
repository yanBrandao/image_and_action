package br.tapajos.example.application.service

import br.tapajos.example.application.domain.Action
import br.tapajos.example.application.port.input.CreateActionUseCase
import br.tapajos.example.application.port.output.ActionRepositoryPort
import org.springframework.stereotype.Service

@Service
class ActionService(
        val actionRepositoryPort: ActionRepositoryPort
): CreateActionUseCase {
    override fun execute(action: Action): Action {
        return actionRepositoryPort.save(action)
    }

}