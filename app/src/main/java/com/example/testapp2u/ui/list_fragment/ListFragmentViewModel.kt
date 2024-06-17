package com.example.testapp2u.ui.list_fragment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testapp2u.data.domain.repository.db.entities.artist.ArtistEntity
import com.example.testapp2u.data.domain.repository.remote.response.BaseResponse
import com.example.testapp2u.data.domain.use_cases.GetArtistsListFromDBUseCase
import com.example.testapp2u.data.domain.use_cases.GetArtistsListFromRemoteUseCase
import com.example.testapp2u.data.domain.use_cases.InsertArtistsAtDBUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ListFragmentViewModel @Inject constructor(
    private val getArtistsListFromRemoteUseCase: GetArtistsListFromRemoteUseCase,
    private val getArtistsListFromDBUseCase: GetArtistsListFromDBUseCase,
    private val insertArtistsAtDBUseCase: InsertArtistsAtDBUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow<ListFragmentUiState>(ListFragmentUiState.Loading)
    val uiState: StateFlow<ListFragmentUiState> = _uiState


    fun getArtistsList() {
        viewModelScope.launch(Dispatchers.IO) {
            when (val baseResponse = getArtistsListFromRemoteUseCase(10, 0)) {
                is BaseResponse.Error -> getArtistsFromDB()
                is BaseResponse.Success -> {
                    insertArtistsAtDB(baseResponse.data)
                }
            }
        }
    }

    fun getArtistsFromDB() {
        viewModelScope.launch(Dispatchers.IO) {
            _uiState.emit(ListFragmentUiState.Success(getArtistsListFromDBUseCase().toMutableList()))
        }
    }

    private fun insertArtistsAtDB(artists: List<ArtistEntity>) {
        viewModelScope.launch(Dispatchers.IO) {
            val deferred = async { insertArtistsAtDBUseCase(artists) }
            deferred.await()
            _uiState.emit(ListFragmentUiState.Success(getArtistsListFromDBUseCase().toMutableList()))
        }
    }
}