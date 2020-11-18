package br.tapajos.example.adapter.output.repository.jpa

import br.tapajos.example.application.domain.Action
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface ActionRepositoryJPA: JpaRepository<Action, Long> {
    @Query("select a from Action a where a.used = false")
    fun findNotUsedAction(): List<Action>
}