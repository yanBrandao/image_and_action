package br.tapajos.example.adapter.input.web.api

import br.tapajos.example.adapter.input.web.api.request.FunRequest
import br.tapajos.example.adapter.input.web.api.response.FunResponse
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import io.swagger.annotations.ApiResponse
import org.springframework.http.HttpStatus.CREATED
import org.springframework.http.HttpStatus.OK
import org.springframework.http.MediaType.APPLICATION_JSON_VALUE
import org.springframework.web.bind.annotation.*

@Api(value = "Image&Action - Fun Manager API")
@RequestMapping(value = ["/v1/funnies"], produces = [APPLICATION_JSON_VALUE])
interface FunAPI {
    @ApiOperation(value = "Create a new fun")
    @ApiResponse(code = 201, message = "Fun Created")
    @ResponseStatus(CREATED)
    @PostMapping(consumes = [APPLICATION_JSON_VALUE])
    fun funn(@RequestBody funRequest: FunRequest): FunResponse

    @ApiOperation(value = "Get some fun")
    @ApiResponse(code = 200, message = "OK")
    @ResponseStatus(OK)
    @GetMapping(path = ["/{funId}"])
    fun getFun(@PathVariable funId: Long): FunResponse
}