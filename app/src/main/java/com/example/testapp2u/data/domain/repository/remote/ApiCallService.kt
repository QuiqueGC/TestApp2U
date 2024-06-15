package com.example.testapp2u.data.domain.repository.remote

import android.util.Log
import com.example.testapp2u.data.domain.repository.remote.response.BaseApiCallService
import com.example.testapp2u.data.domain.repository.remote.response.BaseResponse
import com.example.testapp2u.data.domain.repository.remote.response.artist.ArtistListResponse
import javax.inject.Inject

class ApiCallService @Inject constructor(private val remoteApiService: RemoteApiService) :
    BaseApiCallService() {

    suspend fun getArtistsList(limit: Int, offset: Int): BaseResponse<ArtistListResponse> {
        Log.i("apiCall", "entró en el apiCallService")
        return apiCall { remoteApiService.getArtistsList(limit, offset) }
    }
}