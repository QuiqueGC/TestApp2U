package com.example.testapp2u.data.domain.use_cases

import android.util.Log
import com.example.testapp2u.data.domain.repository.DataProvider
import com.example.testapp2u.data.domain.repository.db.entities.artist.ArtistEntity
import com.example.testapp2u.data.domain.repository.remote.response.BaseResponse
import javax.inject.Inject

class GetArtistsListFromDBUseCase @Inject constructor(private val dataProvider: DataProvider) {

    suspend operator fun invoke(limit: Int, offset: Int): BaseResponse<List<ArtistEntity>> {
        Log.i("apiCall", "entró en el caso de uso")
        return dataProvider.getArtistsListFromRemote(limit, offset)
    }
}