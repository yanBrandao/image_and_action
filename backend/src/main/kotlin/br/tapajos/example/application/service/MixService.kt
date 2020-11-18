package br.tapajos.example.application.service

import br.tapajos.example.application.domain.Mix
import br.tapajos.example.application.port.input.CreateMixUseCase
import br.tapajos.example.application.port.output.MixRepositoryPort
import org.springframework.stereotype.Service

@Service
class MixService(
        val mixRepositoryPort: MixRepositoryPort
): CreateMixUseCase {
    override fun execute(mix: Mix): Mix {
        return mixRepositoryPort.save(mix)
    }

}