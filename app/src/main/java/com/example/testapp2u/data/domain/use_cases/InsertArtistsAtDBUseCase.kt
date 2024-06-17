package com.example.testapp2u.data.domain.use_cases

import com.example.testapp2u.data.domain.repository.DataProvider
import com.example.testapp2u.data.domain.repository.db.entities.artist.ArtistEntity
import javax.inject.Inject

class InsertArtistsAtDBUseCase @Inject constructor(
    private val dataProvider: DataProvider
) {

    suspend operator fun invoke(artists: List<ArtistEntity>) {
        return dataProvider.insertArtistsAtDB(artists)
    }
}