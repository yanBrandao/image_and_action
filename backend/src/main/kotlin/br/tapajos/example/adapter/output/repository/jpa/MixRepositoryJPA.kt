package br.tapajos.example.adapter.output.repository.jpa

import br.tapajos.example.application.domain.Mix
import br.tapajos.example.application.domain.Person
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface MixRepositoryJPA: JpaRepository<Mix, Long> {
    @Query("select m from Mix m where m.used = false")
    fun findNotUsedMix(): List<Mix>
}