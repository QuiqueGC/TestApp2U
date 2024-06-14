package com.example.testapp2u.data.domain.repository.remote

import com.example.testapp2u.data.constants.MyConstants
import com.example.testapp2u.data.domain.repository.remote.response.artist.ArtistListResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface RemoteApiService {
    @GET(MyConstants.BASE_URL)
    suspend fun getArtistsList(
        @Query("limit") limit: Int,
        @Query("offset") offset: Int
    ): Response<ArtistListResponse>
}