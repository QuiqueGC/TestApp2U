package com.example.testapp2u.data.domain.repository.remote.response.artist

import com.google.gson.annotations.SerializedName

data class ArtistListResponse(
    @SerializedName("count") var count: Int? = null,
    @SerializedName("next") var next: String? = null,
    @SerializedName("previous") var previous: String? = null,
    @SerializedName("results") var results: List<ArtistResponse> = listOf(),
    @SerializedName("timestamp") var timestamp: String? = null
)
