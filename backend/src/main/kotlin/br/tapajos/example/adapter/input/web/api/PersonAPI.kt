package br.tapajos.example.adapter.input.web.api

import br.tapajos.example.adapter.input.web.api.request.PersonRequest
import br.tapajos.example.adapter.input.web.api.response.PersonResponse
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import io.swagger.annotations.ApiResponse
import org.springframework.http.HttpStatus.CREATED
import org.springframework.http.HttpStatus.OK
import org.springframework.http.MediaType.APPLICATION_JSON_VALUE
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile

@Api(value = "Image&Action - Person Manager API")
@RequestMapping(value = ["/v1/people"], produces = [APPLICATION_JSON_VALUE])
interface PersonAPI {
    @ApiOperation(value = "Create a new person")
    @ApiResponse(code = 201, message = "Person Created")
    @ResponseStatus(CREATED)
    @PostMapping(consumes = [APPLICATION_JSON_VALUE])
    fun person(@RequestBody personRequest: PersonRequest): PersonResponse

    @ApiOperation(value = "Upload file with person phrases")
    @ApiResponse(code = 200, message = "File uploaded")
    @ResponseStatus(OK)
    @PostMapping
    fun upload(@RequestParam("file") file: MultipartFile)

    @ApiOperation(value = "Get some person")
    @ApiResponse(code = 200, message = "OK")
    @ResponseStatus(OK)
    @GetMapping(path = ["/{personId}"])
    fun getPerson(@PathVariable personId: Long): PersonResponse
}