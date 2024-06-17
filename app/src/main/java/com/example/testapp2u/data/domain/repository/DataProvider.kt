package com.example.testapp2u.data.domain.repository

import android.util.Log
import com.example.testapp2u.data.domain.models.artist.ArtistModel
import com.example.testapp2u.data.domain.repository.db.DBSource
import com.example.testapp2u.data.domain.repository.db.IDBSource
import com.example.testapp2u.data.domain.repository.db.entities.artist.ArtistEntity
import com.example.testapp2u.data.domain.repository.remote.IRemoteDataSource
import com.example.testapp2u.data.domain.repository.remote.RemoteDataSource
import com.example.testapp2u.data.domain.repository.remote.response.BaseResponse
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DataProvider @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val dbDataSource: DBSource
) :
    IRemoteDataSource, IDBSource {
    override suspend fun getArtistsListFromRemote(
        limit: Int,
        offset: Int
    ): BaseResponse<List<ArtistEntity>> {
        Log.i("apiCall", "entró en el dataProvider")
        return remoteDataSource.getArtistsListFromRemote(limit, offset)
    }

    override suspend fun getArtistsFromDB(): List<ArtistModel> {
        return dbDataSource.getArtistsFromDB()
    }
}