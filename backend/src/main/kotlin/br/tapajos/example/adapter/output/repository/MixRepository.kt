package br.tapajos.example.adapter.output.repository

import br.tapajos.example.adapter.output.repository.jpa.MixRepositoryJPA
import br.tapajos.example.application.domain.Mix
import br.tapajos.example.application.domain.Mixes
import br.tapajos.example.application.port.output.MixRepositoryPort
import org.springframework.stereotype.Component

@Component
class MixRepository(
        val mixRepositoryJPA: MixRepositoryJPA
): MixRepositoryPort {
    override fun save(domain: Mix): Mix {
        return mixRepositoryJPA.save(domain)
    }

    override fun findNotUsedMix(): Mixes {
        val list = mixRepositoryJPA.findNotUsedMix()
        return Mixes(list)
    }
}