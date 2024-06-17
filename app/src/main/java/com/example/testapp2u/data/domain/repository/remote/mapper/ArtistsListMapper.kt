package com.example.testapp2u.data.domain.repository.remote.mapper

import com.example.testapp2u.data.domain.repository.db.entities.artist.ArtistEntity
import com.example.testapp2u.data.domain.repository.remote.response.artist.ArtistListResponse
import com.example.testapp2u.data.domain.repository.remote.response.artist.ArtistResponse

class ArtistsListMapper : ResponseMapper<ArtistListResponse, List<ArtistEntity>> {
    override fun fromResponse(response: ArtistListResponse): List<ArtistEntity> {

        return getListOfArtistModel(response.results)
    }

    private fun getListOfArtistModel(
        artistsFromResponse: List<ArtistResponse>
    ): List<ArtistEntity> {

        val artists = mutableListOf<ArtistEntity>()
        artistsFromResponse.forEach {
            artists.add(ArtistMapperFromResponse().fromResponse(it))
        }
        return artists.toList()
    }
}