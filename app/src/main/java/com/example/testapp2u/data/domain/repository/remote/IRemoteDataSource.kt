package com.example.testapp2u.data.domain.repository.remote

import com.example.testapp2u.data.domain.repository.db.entities.artist.ArtistEntity
import com.example.testapp2u.data.domain.repository.remote.response.BaseResponse

interface IRemoteDataSource {
    suspend fun getArtistsListFromRemote(
        limit: Int, offset: Int
    ): BaseResponse<List<ArtistEntity>>
}