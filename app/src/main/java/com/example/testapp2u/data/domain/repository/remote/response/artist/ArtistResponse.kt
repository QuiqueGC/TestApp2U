package com.example.testapp2u.data.domain.repository.remote.response.artist

import com.google.gson.annotations.SerializedName

data class ArtistResponse(
    @SerializedName("id") var id: Int? = null,
    @SerializedName("guid") var guid: String? = null,
    @SerializedName("email") var email: String? = null,
    @SerializedName("first_name") var firstName: String? = null,
    @SerializedName("last_name") var lastName: String? = null,
    @SerializedName("is_removed") var isRemoved: Boolean? = null,
    @SerializedName("description") var description: String? = null,
    @SerializedName("avatar") var avatar: String? = null,
    @SerializedName("image") var image: String? = null,
    @SerializedName("facebook") var facebook: String? = null,
    @SerializedName("instagram") var instagram: String? = null,
    @SerializedName("webpage") var webpage: String? = null
)
