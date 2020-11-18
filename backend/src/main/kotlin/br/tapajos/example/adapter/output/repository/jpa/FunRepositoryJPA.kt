package br.tapajos.example.adapter.output.repository.jpa

import br.tapajos.example.application.domain.Fun
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface FunRepositoryJPA: JpaRepository<Fun, Long> {
    @Query("select f from Fun f where f.used = false")
    fun findNotUsedFun(): List<Fun>
}