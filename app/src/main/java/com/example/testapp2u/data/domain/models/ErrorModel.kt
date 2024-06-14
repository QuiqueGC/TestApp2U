package com.example.testapp2u.data.domain.models


data class ErrorModel(
    var error: String = "Unknown",
    var errorCode: String = "",
    var message: String = "Unknown"
) : BaseModel()