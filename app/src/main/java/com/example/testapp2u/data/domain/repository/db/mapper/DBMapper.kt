package com.example.testapp2u.data.domain.repository.db.mapper

interface DBMapper<E, M> {
    /**
     * Map an entity into a model
     * @param entity the object entity to map
     * @return model object to use at UI
     */
    fun fromEntity(entity: E): M
}