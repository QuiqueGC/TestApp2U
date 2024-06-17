package com.example.testapp2u.data.domain.repository.db

import com.example.testapp2u.data.domain.models.artist.ArtistModel

interface IDBSource {
    suspend fun getArtistsFromDB(): List<ArtistModel>
}