package com.example.testapp2u.data.domain.models


data class ErrorModel(
    var error: String = "An unexpected error occurred",
    var errorCode: String = "",
    var message: String = "An unexpected error occurred"
) : BaseModel()