package br.tapajos.example.application.domain

import org.apache.logging.log4j.util.Strings.EMPTY
import javax.persistence.*

@Entity
data class Mix(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long = 0,
        @Column(unique = true)
        val name: String = EMPTY,
        override var used: Boolean = false
): Phrase