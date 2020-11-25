package br.tapajos.example.application.port.input

import org.springframework.web.multipart.MultipartFile

interface UploadPersonUseCase {
    fun execute(file: MultipartFile)
}