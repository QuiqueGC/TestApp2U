package com.example.testapp2u.data.domain.repository.remote

import com.example.testapp2u.data.domain.models.ErrorModel
import com.example.testapp2u.data.domain.repository.db.entities.artist.ArtistEntity
import com.example.testapp2u.data.domain.repository.remote.mapper.ArtistsListMapper
import com.example.testapp2u.data.domain.repository.remote.response.BaseResponse
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class RemoteDataSource @Inject constructor(private val apiCallService: ApiCallService) :
    IRemoteDataSource {
    override suspend fun getArtistsListFromRemote(
        limit: Int,
        offset: Int
    ): BaseResponse<List<ArtistEntity>> {

        return when (val apiResult = apiCallService.getArtistsList(limit, offset)) {
            is BaseResponse.Success -> BaseResponse.Success(
                ArtistsListMapper().fromResponse(
                    apiResult.data
                )
            )

            is BaseResponse.Error -> BaseResponse.Error(ErrorModel())
        }
    }
}