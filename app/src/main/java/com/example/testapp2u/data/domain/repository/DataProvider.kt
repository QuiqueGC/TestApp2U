package com.example.testapp2u.data.domain.repository

import com.example.testapp2u.data.domain.models.artist.ArtistListModel
import com.example.testapp2u.data.domain.repository.remote.IRemoteDataSource
import com.example.testapp2u.data.domain.repository.remote.RemoteDataSource
import com.example.testapp2u.data.domain.repository.remote.response.BaseResponse
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DataProvider @Inject constructor(private val remoteDataSource: RemoteDataSource) :
    IRemoteDataSource {
    override suspend fun getArtistsList(limit: Int, offset: Int): BaseResponse<ArtistListModel> {
        return remoteDataSource.getArtistsList(limit, offset)
    }
}