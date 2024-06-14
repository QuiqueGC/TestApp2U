package com.example.testapp2u.data.domain.models.artist

import com.example.testapp2u.data.domain.models.BaseModel

data class ArtistListModel(
    var count: Int = 0,
    var next: String = "",
    var previous: String = "",
    var results: MutableList<ArtistModel> = mutableListOf(),
    var timestamp: String = ""
) : BaseModel()
