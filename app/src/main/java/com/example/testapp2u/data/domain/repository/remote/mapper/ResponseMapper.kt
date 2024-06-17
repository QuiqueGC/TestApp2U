package com.example.testapp2u.data.domain.repository.remote.mapper

interface ResponseMapper<R, E> {

    /**
     * Map a response into an entity
     * @param response the object response to map
     * @return entity object to insert at DB
     */
    fun fromResponse(response: R): E
}