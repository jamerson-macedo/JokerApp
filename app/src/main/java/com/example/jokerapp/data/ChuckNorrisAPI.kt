package com.example.jokerapp.data

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ChuckNorrisAPI {
    // ja passo a api
    @GET("jokes/categories")
    fun findallcategories(@Query("apiKey")apiKey:String=HTTPClient.API_KEY):Call<List<String>>
}