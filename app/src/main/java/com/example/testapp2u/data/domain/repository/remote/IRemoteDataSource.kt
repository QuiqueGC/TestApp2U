package com.example.testapp2u.data.domain.repository.remote

import com.example.testapp2u.data.domain.repository.db.entities.artist.ArtistEntity
import com.example.testapp2u.data.domain.repository.remote.response.BaseResponse

interface IRemoteDataSource {

    /**
     * Take the list of artists from API
     * @param limit int with the max of the artists to take
     * @param offset int with the position to start to take
     * @return BaseResponse with a list of ArtistEntities
     */
    suspend fun getArtistsListFromRemote(
        limit: Int, offset: Int
    ): BaseResponse<List<ArtistEntity>>
}