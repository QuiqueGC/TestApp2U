package com.example.testapp2u.ui.detail_fragment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testapp2u.data.domain.use_cases.GetArtistByIdFromDB
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailFragmentViewModel @Inject constructor(
    private val getArtistByIdFromDB: GetArtistByIdFromDB
) : ViewModel() {

    private val _uiState = MutableStateFlow<DetailFragmentUiState>(DetailFragmentUiState.Loading)
    val uiState: StateFlow<DetailFragmentUiState> = _uiState

    fun getArtistById(idArtist: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            _uiState.emit(DetailFragmentUiState.Success(getArtistByIdFromDB(idArtist)))
        }
    }
}