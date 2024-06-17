package com.example.testapp2u.data.domain.use_cases

import com.example.testapp2u.data.domain.models.artist.ArtistModel
import com.example.testapp2u.data.domain.repository.DataProvider
import javax.inject.Inject

class GetArtistsListFromDBUseCase @Inject constructor(private val dataProvider: DataProvider) {

    suspend operator fun invoke(): List<ArtistModel> {
        return dataProvider.getArtistsFromDB()
    }
}