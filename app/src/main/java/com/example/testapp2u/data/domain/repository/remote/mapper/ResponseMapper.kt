package com.example.testapp2u.data.domain.repository.remote.mapper

interface ResponseMapper<R, E> {
    fun fromResponse(response: R): E
}