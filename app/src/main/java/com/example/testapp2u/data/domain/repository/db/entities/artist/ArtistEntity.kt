package com.example.testapp2u.data.domain.repository.db.entities.artist

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "artist_table")
data class ArtistEntity(
    @PrimaryKey
    @ColumnInfo("id") var id: Int,
    @ColumnInfo("guid") var guid: String,
    @ColumnInfo("email") var email: String,
    @ColumnInfo("firstName") var firstName: String,
    @ColumnInfo("lastName") var lastName: String,
    @ColumnInfo("isRemoved") var isRemoved: Boolean,
    @ColumnInfo("description") var description: String,
    @ColumnInfo("avatar") var avatar: String,
    @ColumnInfo("image") var image: String,
    @ColumnInfo("facebook") var facebook: String,
    @ColumnInfo("instagram") var instagram: String,
    @ColumnInfo("webpage") var webpage: String
)
