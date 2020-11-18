package br.tapajos.example.adapter.output.repository.jpa

import br.tapajos.example.application.domain.Objectt
import br.tapajos.example.application.domain.Person
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface ObjectRepositoryJPA: JpaRepository<Objectt, Long> {
    @Query("select o from Objectt o where o.used = false")
    fun findNotUsedObject(): List<Objectt>
}