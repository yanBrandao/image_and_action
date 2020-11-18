package br.tapajos.example.application.domain

import br.tapajos.example.application.port.output.HardRepositoryPort

class Difficult(override val list: List<Hard>): GroupPhrase<Hard, HardRepositoryPort>(list){
    override fun toString(): String {
        return "Hard Phrases"
    }
}