package br.tapajos.example.application.service

import br.tapajos.example.application.domain.Hard
import br.tapajos.example.application.port.input.CreateHardUseCase
import br.tapajos.example.application.port.output.HardRepositoryPort
import org.springframework.stereotype.Service

@Service
class HardService(
        val hardRepositoryPort: HardRepositoryPort
): CreateHardUseCase {
    override fun execute(hard: Hard): Hard {
        return hardRepositoryPort.save(hard)
    }

}