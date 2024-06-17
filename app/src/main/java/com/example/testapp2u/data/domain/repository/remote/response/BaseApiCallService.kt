package com.example.testapp2u.data.domain.repository.remote.response

import com.example.testapp2u.data.domain.models.ErrorModel
import retrofit2.Response

abstract class BaseApiCallService {
    suspend fun <T : Any> apiCall(call: suspend () -> Response<T>): BaseResponse<T> {
        val response: Response<T>

        //return BaseResponse.Error(ErrorModel())

        return try {
            response = call.invoke()
            if (response.isSuccessful) {

                response.body()?.let { body ->
                    BaseResponse.Success(body)
                } ?: BaseResponse.Error(
                    ErrorModel(
                        response.code().toString(),
                        response.code().toString(),
                        response.message()
                    )
                )

            } else {

                BaseResponse.Error(
                    ErrorModel(
                        response.code().toString(),
                        response.code().toString(),
                        response.message()
                    )
                )
            }

        } catch (throwable: Throwable) {
            BaseResponse.Error(ErrorModel())
        }
    }
}