package br.tapajos.example.application.port.output

interface GenericRepositoryPort<D> {
    fun save(domain: D): D
}