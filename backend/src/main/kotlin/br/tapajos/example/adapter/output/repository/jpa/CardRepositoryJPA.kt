package br.tapajos.example.adapter.output.repository.jpa

import br.tapajos.example.application.domain.Card
import org.springframework.data.jpa.repository.JpaRepository

interface CardRepositoryJPA: JpaRepository<Card, Long>