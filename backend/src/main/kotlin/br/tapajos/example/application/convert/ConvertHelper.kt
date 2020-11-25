package br.tapajos.example.application.convert

import br.tapajos.example.application.domain.Type

fun String.toType(): Type {
    return when(this) {
        "Person" -> Type.P
        "Action" -> Type.A
        "Hard" -> Type.H
        "Object" -> Type.O
        "Fun" -> Type.F
        else -> Type.M
    }
}