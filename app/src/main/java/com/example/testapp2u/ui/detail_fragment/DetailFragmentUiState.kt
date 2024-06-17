package com.example.testapp2u.ui.detail_fragment

import com.example.testapp2u.data.domain.models.artist.ArtistModel

sealed class DetailFragmentUiState {
    data object Loading : DetailFragmentUiState()
    class Success(val artist: ArtistModel) : DetailFragmentUiState()
}