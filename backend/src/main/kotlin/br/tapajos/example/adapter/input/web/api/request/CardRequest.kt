package br.tapajos.example.adapter.input.web.api.request

import org.apache.logging.log4j.util.Strings.EMPTY

data class CardRequest(
        val personWord: String = EMPTY,
        val objectWord: String = EMPTY,
        val mixWord: String = EMPTY,
        val hardWord: String = EMPTY,
        val actionWord: String = EMPTY,
        val funWord: String = EMPTY
)