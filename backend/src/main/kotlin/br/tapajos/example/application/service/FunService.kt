package br.tapajos.example.application.service

import br.tapajos.example.application.domain.Fun
import br.tapajos.example.application.port.input.CreateFunUseCase
import br.tapajos.example.application.port.output.FunRepositoryPort
import org.springframework.stereotype.Service

@Service
class FunService(
        val funRepositoryPort: FunRepositoryPort
): CreateFunUseCase {
    override fun execute(funn: Fun): Fun {
        return funRepositoryPort.save(funn)
    }

}