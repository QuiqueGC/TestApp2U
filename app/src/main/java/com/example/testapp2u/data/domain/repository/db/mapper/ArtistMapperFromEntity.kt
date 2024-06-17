package com.example.testapp2u.data.domain.repository.db.mapper

import com.example.testapp2u.data.domain.models.artist.ArtistModel
import com.example.testapp2u.data.domain.repository.db.entities.artist.ArtistEntity

class ArtistMapperFromEntity : DBMapper<ArtistEntity, ArtistModel> {
    override fun fromEntity(entity: ArtistEntity): ArtistModel {
        val description = entity.description.ifEmpty {
            "Description not available"
        }

        return ArtistModel(
            entity.id,
            entity.firstName,
            entity.lastName,
            description,
            entity.image
        )
    }
}