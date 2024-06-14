package com.example.testapp2u.ui.list_fragment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testapp2u.data.domain.repository.remote.response.BaseResponse
import com.example.testapp2u.data.domain.use_cases.GetArtistsListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ListFragmentViewModel @Inject constructor(
    private val getArtistsListUseCase: GetArtistsListUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow<ListFragmentUiState>(ListFragmentUiState.Loading)
    val uiState: StateFlow<ListFragmentUiState> = _uiState


    fun getArtistsList() {
        viewModelScope.launch(Dispatchers.IO) {
            when (val baseResponse = getArtistsListUseCase(10, 0)) {
                is BaseResponse.Error -> _uiState.emit(ListFragmentUiState.Error(baseResponse.error))
                is BaseResponse.Success -> _uiState.emit(ListFragmentUiState.Success(baseResponse.data.results))
            }
        }
    }
}