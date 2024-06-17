package com.example.testapp2u.data.domain.repository.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.testapp2u.data.domain.repository.db.entities.artist.ArtistEntity

@Dao
interface ArtistDao {

    /**
     * Take the list of artist not removed from DB
     * @return List with the artistEntities
     */
    @Query("SELECT * FROM artist_table WHERE isRemoved = 0")
    suspend fun getAllArtists(): List<ArtistEntity>

    /**
     * Take a list (it must be just one element) of artists
     * with the id passed for parameters
     * @param idArtist int with the id of the artist to take
     * @return list with the artistEntity found
     */
    @Query("SELECT * FROM artist_table WHERE id = :idArtist")
    suspend fun getArtistById(idArtist: Int): List<ArtistEntity>

    /**
     * Insert a list of artist in DB (replace the artist
     * in case of same id)
     * @param artists list with the artistEntities to insert
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllArtists(artists: List<ArtistEntity>)
}