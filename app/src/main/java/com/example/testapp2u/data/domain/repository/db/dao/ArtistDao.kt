package com.example.testapp2u.data.domain.repository.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.testapp2u.data.domain.repository.db.entities.artist.ArtistEntity

@Dao
interface ArtistDao {

    @Query("SELECT * FROM artist_table WHERE isRemoved = 0")
    suspend fun getAllArtists(): List<ArtistEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllArtists(artists: List<ArtistEntity>)

    @Query("DELETE FROM artist_table")
    suspend fun deleteArtists()
}