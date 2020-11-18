package br.tapajos.example.adapter.input.web.api

import br.tapajos.example.adapter.input.web.api.request.ObjectRequest
import br.tapajos.example.adapter.input.web.api.response.ObjectResponse
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import io.swagger.annotations.ApiResponse
import org.springframework.http.HttpStatus.CREATED
import org.springframework.http.HttpStatus.OK
import org.springframework.http.MediaType.APPLICATION_JSON_VALUE
import org.springframework.web.bind.annotation.*

@Api(value = "Image&Action - Object Manager API")
@RequestMapping(value = ["/v1/objects"], produces = [APPLICATION_JSON_VALUE])
interface ObjectAPI {
    @ApiOperation(value = "Create a new objects")
    @ApiResponse(code = 201, message = "Object Created")
    @ResponseStatus(CREATED)
    @PostMapping(consumes = [APPLICATION_JSON_VALUE])
    fun objectt(@RequestBody objectRequest: ObjectRequest): ObjectResponse

    @ApiOperation(value = "Get some object")
    @ApiResponse(code = 200, message = "OK")
    @ResponseStatus(OK)
    @GetMapping(path = ["/{objectId}"])
    fun getObject(@PathVariable objectId: Long): ObjectResponse
}