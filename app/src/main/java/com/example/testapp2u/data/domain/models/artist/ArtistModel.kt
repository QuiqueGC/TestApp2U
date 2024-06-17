package com.example.testapp2u.data.domain.models.artist

import com.example.testapp2u.data.domain.models.BaseModel

data class ArtistModel(
    var id: Int = -1,
    var firstName: String = "",
    var lastName: String = "",
    var description: String = "",
    var image: String = "",
) : BaseModel()
