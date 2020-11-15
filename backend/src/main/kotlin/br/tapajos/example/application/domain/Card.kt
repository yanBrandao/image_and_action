package br.tapajos.example.application.domain

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class Card(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long = 0,
        val peopleWord: String = "",
        val objectWord: String = "",
        val mixWord: String = "",
        val hardWord: String = "",
        val actionWord: String = ""
)