package com.example.testapp2u.data.domain.repository.remote.response

import com.example.testapp2u.data.domain.models.ErrorModel


sealed class BaseResponse<T> {
    data class Success<T>(val data: T) : BaseResponse<T>()
    data class Error<T>(val error: ErrorModel) : BaseResponse<T>()
}