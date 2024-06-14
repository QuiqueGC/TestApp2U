package com.example.testapp2u.data.domain.repository.remote.mapper

interface ResponseMapper<R, M> {
    fun fromResponse(response: R): M
}