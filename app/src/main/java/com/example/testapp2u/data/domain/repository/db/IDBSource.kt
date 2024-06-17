package com.example.testapp2u.data.domain.repository.db

import com.example.testapp2u.data.domain.models.artist.ArtistModel
import com.example.testapp2u.data.domain.repository.db.entities.artist.ArtistEntity

interface IDBSource {
    suspend fun getArtistsFromDB(): List<ArtistModel>
    suspend fun insertArtistsAtDB(artists: List<ArtistEntity>)
    suspend fun getArtistByIdFromDB(idArtist: Int): ArtistModel
}