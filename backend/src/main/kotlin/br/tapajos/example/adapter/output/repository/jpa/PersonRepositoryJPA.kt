package br.tapajos.example.adapter.output.repository.jpa

import br.tapajos.example.application.domain.Person
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface PersonRepositoryJPA: JpaRepository<Person, Long> {
    @Query("select p from Person p where p.used = false")
    fun findNotUsedPerson(): List<Person>
}