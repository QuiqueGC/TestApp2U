package com.example.testapp2u.data.domain.models.artist

import com.example.testapp2u.data.domain.models.BaseModel
import com.example.testapp2u.data.domain.repository.remote.response.artist.ArtistResponse

data class ArtistListModel(
    var count: Int = 0,
    var next: String = "",
    var previous: String = "",
    var results: MutableList<ArtistResponse> = mutableListOf(),
    var timestamp: String = ""
) : BaseModel()
