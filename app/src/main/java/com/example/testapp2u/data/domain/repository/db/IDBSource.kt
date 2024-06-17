package com.example.testapp2u.data.domain.repository.db

import com.example.testapp2u.data.domain.models.artist.ArtistModel
import com.example.testapp2u.data.domain.repository.db.entities.artist.ArtistEntity

interface IDBSource {

    /**
     * Take the list of artist not removed from DB
     * @return list of artistModels
     */
    suspend fun getArtistsFromDB(): List<ArtistModel>

    /**
     * Take a list (it must be just one element) of artistModels
     * with the id passed for parameters
     * @param idArtist int with the id to find
     * @return artistModel
     */
    suspend fun getArtistByIdFromDB(idArtist: Int): ArtistModel

    /**
     * Insert a list of artist in DB (replace the artist
     * in case of same id)
     * @param artists list of artistEntities to insert
     */
    suspend fun insertArtistsAtDB(artists: List<ArtistEntity>)


}