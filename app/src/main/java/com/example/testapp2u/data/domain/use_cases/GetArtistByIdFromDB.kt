package com.example.testapp2u.data.domain.use_cases

import com.example.testapp2u.data.domain.models.artist.ArtistModel
import com.example.testapp2u.data.domain.repository.DataProvider
import javax.inject.Inject

class GetArtistByIdFromDB @Inject constructor(
    private val dataProvider: DataProvider
) {
    suspend operator fun invoke(idArtist: Int): ArtistModel {
        return dataProvider.getArtistByIdFromDB(idArtist)
    }
}