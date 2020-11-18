package br.tapajos.example.adapter.input.web.api

import br.tapajos.example.adapter.input.web.api.request.ActionRequest
import br.tapajos.example.adapter.input.web.api.response.ActionResponse
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import io.swagger.annotations.ApiResponse
import org.springframework.http.HttpStatus.CREATED
import org.springframework.http.HttpStatus.OK
import org.springframework.http.MediaType.APPLICATION_JSON_VALUE
import org.springframework.web.bind.annotation.*

@Api(value = "Image&Action - Action Manager API")
@RequestMapping(value = ["/v1/actions"], produces = [APPLICATION_JSON_VALUE])
interface ActionAPI {
    @ApiOperation(value = "Create a new action")
    @ApiResponse(code = 201, message = "Action Created")
    @ResponseStatus(CREATED)
    @PostMapping(consumes = [APPLICATION_JSON_VALUE])
    fun action(@RequestBody actionRequest: ActionRequest): ActionResponse

    @ApiOperation(value = "Get some action")
    @ApiResponse(code = 200, message = "OK")
    @ResponseStatus(OK)
    @GetMapping(path = ["/{actionId}"])
    fun getAction(@PathVariable actionId: Long): ActionResponse
}