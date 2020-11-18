package br.tapajos.example.adapter.output.repository

import br.tapajos.example.adapter.output.repository.jpa.HardRepositoryJPA
import br.tapajos.example.application.domain.Difficult
import br.tapajos.example.application.domain.Hard
import br.tapajos.example.application.port.output.HardRepositoryPort
import org.springframework.stereotype.Component

@Component
class HardRepository(
        val hardRepositoryJPA: HardRepositoryJPA
): HardRepositoryPort {
    override fun save(domain: Hard): Hard {
        return hardRepositoryJPA.save(domain)
    }

    override fun findNotUsedHard(): Difficult {
        val list = hardRepositoryJPA.findNotUsedHard()
        return Difficult(list)
    }
}