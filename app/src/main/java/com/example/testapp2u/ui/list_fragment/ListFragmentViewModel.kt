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
        var offset = 0
        val limit = 50
        var isFinished = false

        viewModelScope.launch(Dispatchers.IO) {
            do {
                when (val baseResponse = getArtistsListFromRemoteUseCase(limit, offset)) {
                    is BaseResponse.Error -> {
                        isFinished = true
                    }

                    is BaseResponse.Success -> {
                        val deferred = async { insertArtistsAtDB(baseResponse.data) }
                        deferred.await()
                        offset += limit
                        if (baseResponse.data.isEmpty()) {
                            isFinished = true
                        }
                    }
                }
            } while (!isFinished)

            _uiState.emit(
                ListFragmentUiState.Success(getArtistsListFromDBUseCase().toMutableList())
            )
        }
    }

    private suspend fun insertArtistsAtDB(artists: List<ArtistEntity>) {
        insertArtistsAtDBUseCase(artists)
    }
}