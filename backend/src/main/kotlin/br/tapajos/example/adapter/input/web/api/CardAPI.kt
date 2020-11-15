package br.tapajos.example.adapter.input.web.api

import br.tapajos.example.adapter.input.web.api.request.CardRequest
import br.tapajos.example.adapter.input.web.api.response.CardIdResponse
import br.tapajos.example.adapter.input.web.api.response.CardResponse
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import io.swagger.annotations.ApiResponse
import org.springframework.http.HttpStatus.CREATED
import org.springframework.http.HttpStatus.OK
import org.springframework.http.MediaType.APPLICATION_JSON_VALUE
import org.springframework.web.bind.annotation.*

@Api(value = "Image&Action - Card Manager API")
@RequestMapping(value = ["/v1/cards"], produces = [APPLICATION_JSON_VALUE])
interface CardAPI {
    @ApiOperation(value = "Create a new card")
    @ApiResponse(code = 201, message = "Card Created")
    @ResponseStatus(CREATED)
    @PostMapping(consumes = [APPLICATION_JSON_VALUE])
    fun card(@RequestBody cardRequest: CardRequest): CardIdResponse

    @ApiOperation(value = "Get some card")
    @ApiResponse(code = 200, message = "OK")
    @ResponseStatus(OK)
    @GetMapping(path = ["/{cardId}"])
    fun getCard(@PathVariable cardId: Long): CardResponse
}