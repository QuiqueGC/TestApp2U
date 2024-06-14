package com.example.testapp2u.data.domain.repository.remote.mapper

import com.example.testapp2u.data.domain.models.artist.ArtistListModel
import com.example.testapp2u.data.domain.models.artist.ArtistModel
import com.example.testapp2u.data.domain.repository.remote.response.artist.ArtistListResponse
import com.example.testapp2u.data.domain.repository.remote.response.artist.ArtistResponse

class ArtistsListMapper : ResponseMapper<ArtistListResponse, ArtistListModel> {
    override fun fromResponse(response: ArtistListResponse): ArtistListModel {

        return ArtistListModel(
            response.count ?: 0,
            response.next ?: "",
            response.previous ?: "",
            getListOfArtistModel(response.results),
            response.timestamp ?: ""
        )
    }

    private fun getListOfArtistModel(artistsFromResponse: List<ArtistResponse>): MutableList<ArtistModel> {
        val artists = mutableListOf<ArtistModel>()
        artistsFromResponse.forEach { artists.add(ArtistMapper().fromResponse(it)) }
        return artists
    }
}