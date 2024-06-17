package com.example.testapp2u.ui.list_fragment

import com.example.testapp2u.data.domain.models.artist.ArtistModel

sealed class ListFragmentUiState {
    data object Loading : ListFragmentUiState()
    class Success(val artists: MutableList<ArtistModel>) : ListFragmentUiState()
}