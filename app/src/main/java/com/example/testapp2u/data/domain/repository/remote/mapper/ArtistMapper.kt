package com.example.testapp2u.data.domain.repository.remote.mapper

import com.example.testapp2u.data.domain.models.artist.ArtistModel
import com.example.testapp2u.data.domain.repository.remote.response.artist.ArtistResponse

class ArtistMapper : ResponseMapper<ArtistResponse, ArtistModel> {
    override fun fromResponse(response: ArtistResponse): ArtistModel {
        return ArtistModel(
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