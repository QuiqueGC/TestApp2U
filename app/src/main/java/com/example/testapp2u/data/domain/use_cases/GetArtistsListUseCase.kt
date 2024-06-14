package com.example.testapp2u.data.domain.use_cases

import com.example.testapp2u.data.domain.models.artist.ArtistListModel
import com.example.testapp2u.data.domain.repository.DataProvider
import com.example.testapp2u.data.domain.repository.remote.response.BaseResponse
import javax.inject.Inject

class GetArtistsListUseCase @Inject constructor(private val dataProvider: DataProvider) {

    suspend operator fun invoke(limit: Int, offset: Int): BaseResponse<ArtistListModel> {
        return dataProvider.getArtistsList(limit, offset)
    }
}