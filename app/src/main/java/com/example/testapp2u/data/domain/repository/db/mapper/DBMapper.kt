package com.example.testapp2u.data.domain.repository.db.mapper

interface DBMapper<E, M> {
    fun fromEntity(entity: E): M
}