package com.example.testapp2u.data.domain.models.artist

import com.example.testapp2u.data.domain.models.BaseModel

data class ArtistModel(
    var id: Int,
    var guid: String,
    var email: String = "",
    var firstName: String,
    var lastName: String = "",
    var isRemoved: Boolean,
    var description: String,
    var avatar: String = "",
    var image: String = "",
    var facebook: String = "",
    var instagram: String = "",
    var webpage: String = ""
) : BaseModel()
