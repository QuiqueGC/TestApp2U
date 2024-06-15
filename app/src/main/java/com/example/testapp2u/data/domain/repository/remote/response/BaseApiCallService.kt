package com.example.testapp2u.data.domain.repository.remote.response

import android.util.Log
import com.example.testapp2u.data.domain.models.ErrorModel
import retrofit2.Response

abstract class BaseApiCallService {
    suspend fun <T : Any> apiCall(call: suspend () -> Response<T>): BaseResponse<T> {
        val response: Response<T>

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
            Log.i("apiCall", "No es capaz de efectuar la llamada y salta el Catch")
            BaseResponse.Error(ErrorModel())
        }
    }
}