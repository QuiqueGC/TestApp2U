package com.example.testapp2u.data.domain.repository.remote.mapper

import com.example.testapp2u.data.domain.repository.db.entities.artist.ArtistEntity
import com.example.testapp2u.data.domain.repository.remote.response.artist.ArtistResponse

class ArtistMapperFromResponse : ResponseMapper<ArtistResponse, ArtistEntity> {
    override fun fromResponse(response: ArtistResponse): ArtistEntity {
        return ArtistEntity(
            response.id ?: -1,
            response.guid ?: "",
            response.email ?: "",
            response.firstName ?: "",
            response.lastName ?: "",
            response.isRemoved ?: false,
            response.description ?: "",
            response.avatar ?: "",
            response.image ?: "",
            response.facebook ?: "",
            response.instagram ?: "",
            response.webpage ?: "",
        )
    }
}