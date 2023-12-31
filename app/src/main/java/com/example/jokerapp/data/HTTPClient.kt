package com.example.jokerapp.data

import okhttp3.OkHttp
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object HTTPClient {
    private const val BASE_URL = "https://api.tiagoaguiar.co/jokerapp/"
    const val API_KEY = "e62fd10a-f1ad-4a7e-b2bd-63efd89a27b0"

    private fun httpClient(): OkHttpClient {
        val interceptor = HttpLoggingInterceptor()
        // vendo onde vou 9interceptar
        interceptor.level = HttpLoggingInterceptor.Level.BODY

       return OkHttpClient.Builder().addInterceptor(interceptor).build()


    }

    fun retrofit() = Retrofit.Builder().baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create()).client(httpClient()).build()

}