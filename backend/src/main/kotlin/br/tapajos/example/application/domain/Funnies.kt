package br.tapajos.example.application.domain

import br.tapajos.example.application.port.output.FunRepositoryPort

class Funnies(override val list: List<Fun>): GroupPhrase<Fun, FunRepositoryPort>(list){
    override fun toString(): String {
        return "Fun Phrases"
    }
}