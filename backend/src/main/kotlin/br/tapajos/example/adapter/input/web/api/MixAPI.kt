package br.tapajos.example.adapter.input.web.api

import br.tapajos.example.adapter.input.web.api.request.MixRequest
import br.tapajos.example.adapter.input.web.api.response.MixResponse
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import io.swagger.annotations.ApiResponse
import org.springframework.http.HttpStatus.CREATED
import org.springframework.http.HttpStatus.OK
import org.springframework.http.MediaType.APPLICATION_JSON_VALUE
import org.springframework.web.bind.annotation.*

@Api(value = "Image&Action - Mix Manager API")
@RequestMapping(value = ["/v1/mixes"], produces = [APPLICATION_JSON_VALUE])
interface MixAPI {
    @ApiOperation(value = "Create a new mix")
    @ApiResponse(code = 201, message = "Mix Created")
    @ResponseStatus(CREATED)
    @PostMapping(consumes = [APPLICATION_JSON_VALUE])
    fun mix(@RequestBody mixRequest: MixRequest): MixResponse

    @ApiOperation(value = "Get some mix")
    @ApiResponse(code = 200, message = "OK")
    @ResponseStatus(OK)
    @GetMapping(path = ["/{mixId}"])
    fun getMix(@PathVariable mixId: Long): MixResponse
}