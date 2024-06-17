package com.example.testapp2u.data.domain.repository.db

import com.example.testapp2u.data.domain.models.artist.ArtistModel
import com.example.testapp2u.data.domain.repository.db.dao.ArtistDao
import com.example.testapp2u.data.domain.repository.db.entities.artist.ArtistEntity
import com.example.testapp2u.data.domain.repository.db.mapper.ArtistMapperFromEntity
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DBSource @Inject constructor(private val artistDao: ArtistDao) : IDBSource {

    override suspend fun getArtistsFromDB(): List<ArtistModel> {
        val artistsEntities = artistDao.getAllArtists()
        val artistsModels = mutableListOf<ArtistModel>()
        artistsEntities.forEach { artistsModels.add(ArtistMapperFromEntity().fromEntity(it)) }
        return artistsModels.toList()
    }

    override suspend fun insertArtistsAtDB(artists: List<ArtistEntity>) {
        artistDao.insertAllArtists(artists)
    }

    override suspend fun getArtistByIdFromDB(idArtist: Int): ArtistModel {
        return ArtistMapperFromEntity().fromEntity(artistDao.getArtistById(idArtist).first())
    }
}