package br.tapajos.example.adapter.output.repository.jpa

import br.tapajos.example.application.domain.Hard
import br.tapajos.example.application.domain.Person
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface HardRepositoryJPA: JpaRepository<Hard, Long> {
    @Query("select h from Hard h where h.used = false")
    fun findNotUsedHard(): List<Hard>
}