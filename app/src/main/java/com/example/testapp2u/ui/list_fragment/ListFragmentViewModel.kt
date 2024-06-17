package com.example.testapp2u.ui.list_fragment

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testapp2u.data.domain.repository.remote.response.BaseResponse
import com.example.testapp2u.data.domain.use_cases.GetArtistsListFromRemoteUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ListFragmentViewModel @Inject constructor(
    private val getArtistsListFromRemoteUseCase: GetArtistsListFromRemoteUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow<ListFragmentUiState>(ListFragmentUiState.Loading)
    val uiState: StateFlow<ListFragmentUiState> = _uiState


    fun getArtistsList() {
        viewModelScope.launch(Dispatchers.IO) {
            Log.i("apiCall", "llama al caso de uso")
            when (val baseResponse = getArtistsListFromRemoteUseCase(10, 0)) {
                is BaseResponse.Error -> _uiState.emit(ListFragmentUiState.Error(baseResponse.error))
                is BaseResponse.Success -> {}
            }
            Log.i("apiCall", "terminó la llamada al caso de uso")
        }
    }
}