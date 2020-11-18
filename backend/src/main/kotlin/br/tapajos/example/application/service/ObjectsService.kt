package br.tapajos.example.application.service

import br.tapajos.example.application.domain.Objectt
import br.tapajos.example.application.port.input.CreateObjectsUseCase
import br.tapajos.example.application.port.output.ObjectRepositoryPort
import org.springframework.stereotype.Service

@Service
class ObjectsService(
        val objectRepositoryPort: ObjectRepositoryPort
): CreateObjectsUseCase {
    override fun execute(objectt: Objectt): Objectt {
        return objectRepositoryPort.save(objectt)
    }
}