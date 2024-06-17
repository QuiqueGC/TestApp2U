package com.example.testapp2u.data.domain.use_cases

import android.util.Log
import com.example.testapp2u.data.domain.models.artist.ArtistModel
import com.example.testapp2u.data.domain.repository.DataProvider
import javax.inject.Inject

class GetArtistsListFromDBUseCase @Inject constructor(private val dataProvider: DataProvider) {

    suspend operator fun invoke(): List<ArtistModel> {
        Log.i("apiCall", "entró en el caso de uso")
        return dataProvider.getArtistsFromDB()
    }
}