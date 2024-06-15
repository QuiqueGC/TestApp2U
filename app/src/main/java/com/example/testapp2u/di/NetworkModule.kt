package com.example.testapp2u.di

import com.example.testapp2u.data.constants.MyConstants
import com.example.testapp2u.data.domain.repository.remote.RemoteApiService
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Credentials
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton
import javax.net.ssl.SSLContext
import javax.net.ssl.TrustManager
import javax.net.ssl.X509TrustManager

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideOkHttpClient(): OkHttpClient {
        /*return OkHttpClient.Builder()
            .addInterceptor { chain ->
                val original = chain.request()
                val requestBuilder = original.newBuilder()
                    .header(
                        "Authorization",
                        Credentials.basic(
                            MyConstants.USER_NAME_API_CALL,
                            MyConstants.PASSWD_API_CALL
                        )
                    )
                val request = requestBuilder.build()
                chain.proceed(request)
            }
            .build()*/
        // Crear un TrustManager que confía en todos los certificados
        val trustAllCerts = arrayOf<TrustManager>(
            object : X509TrustManager {
                override fun checkClientTrusted(
                    chain: Array<java.security.cert.X509Certificate>,
                    authType: String
                ) {
                }

                override fun checkServerTrusted(
                    chain: Array<java.security.cert.X509Certificate>,
                    authType: String
                ) {
                }

                override fun getAcceptedIssuers(): Array<java.security.cert.X509Certificate> {
                    return arrayOf()
                }
            }
        )

        // Instalar el TrustManager que confía en todos los certificados
        val sslContext = SSLContext.getInstance("SSL")
        sslContext.init(null, trustAllCerts, java.security.SecureRandom())

        // Crear un SSL socket factory con nuestro TrustManager
        val sslSocketFactory = sslContext.socketFactory

        return OkHttpClient.Builder()
            .sslSocketFactory(sslSocketFactory, trustAllCerts[0] as X509TrustManager)
            .hostnameVerifier { _, _ -> true }
            .addInterceptor { chain ->
                val original = chain.request()
                val requestBuilder = original.newBuilder()
                    .header(
                        "Authorization",
                        Credentials.basic(
                            MyConstants.USER_NAME_API_CALL,
                            MyConstants.PASSWD_API_CALL
                        )
                    )
                val request = requestBuilder.build()
                chain.proceed(request)
            }
            .build()
    }

    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        val gson = GsonBuilder().setLenient().create()

        return Retrofit.Builder()
            .baseUrl(MyConstants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(okHttpClient)
            .build()
    }

    @Singleton
    @Provides
    fun provideRemoteApiService(retrofit: Retrofit): RemoteApiService {
        return retrofit.create(RemoteApiService::class.java)
    }
}