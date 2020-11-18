package br.tapajos.example.adapter.input.web.api

import br.tapajos.example.adapter.input.web.api.request.HardRequest
import br.tapajos.example.adapter.input.web.api.response.HardResponse
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import io.swagger.annotations.ApiResponse
import org.springframework.http.HttpStatus.CREATED
import org.springframework.http.HttpStatus.OK
import org.springframework.http.MediaType.APPLICATION_JSON_VALUE
import org.springframework.web.bind.annotation.*

@Api(value = "Image&Action - Hard Manager API")
@RequestMapping(value = ["/v1/difficult"], produces = [APPLICATION_JSON_VALUE])
interface HardAPI {
    @ApiOperation(value = "Create a new hard word")
    @ApiResponse(code = 201, message = "Hard Created")
    @ResponseStatus(CREATED)
    @PostMapping(consumes = [APPLICATION_JSON_VALUE])
    fun hard(@RequestBody hardRequest: HardRequest): HardResponse

    @ApiOperation(value = "Get some hard")
    @ApiResponse(code = 200, message = "OK")
    @ResponseStatus(OK)
    @GetMapping(path = ["/{hardId}"])
    fun getHard(@PathVariable hardId: Long): HardResponse
}