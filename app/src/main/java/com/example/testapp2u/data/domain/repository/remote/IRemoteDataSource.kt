package com.example.testapp2u.data.domain.repository.remote

import com.example.testapp2u.data.domain.models.artist.ArtistListModel
import com.example.testapp2u.data.domain.repository.remote.response.BaseResponse

interface IRemoteDataSource {
    suspend fun getArtistsList(limit: Int, offset: Int): BaseResponse<ArtistListModel>
}