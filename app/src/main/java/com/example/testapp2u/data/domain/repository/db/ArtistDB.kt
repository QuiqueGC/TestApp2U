package com.example.testapp2u.data.domain.repository.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.testapp2u.data.domain.repository.db.dao.ArtistDao
import com.example.testapp2u.data.domain.repository.db.entities.artist.ArtistEntity

@Database(entities = [ArtistEntity::class], version = 1)
abstract class ArtistDB : RoomDatabase() {

    abstract fun getArtistDao(): ArtistDao
}