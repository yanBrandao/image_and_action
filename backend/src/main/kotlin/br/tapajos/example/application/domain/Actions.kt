package br.tapajos.example.application.domain

import br.tapajos.example.application.port.output.ActionRepositoryPort

class Actions(override val list: List<Action>): GroupPhrase<Action, ActionRepositoryPort>(list){
    override fun toString(): String {
        return "Hard Phrases"
    }
}