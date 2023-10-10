package com.example.jokerapp.data

import com.example.jokerapp.model.Joke
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ChuckNorrisAPI {
    // ja passo a api
    @GET("jokes/categories")
    fun findallcategories(@Query("apiKey")apiKey:String=HTTPClient.API_KEY):Call<List<String>>
    @GET("jokes/random")//query troca os valores e passa o que tem que ser
    fun findBy(@Query("category")categoryname:String,@Query("apiKey")apiKey: String=HTTPClient.API_KEY):Call<Joke>
    @GET("jokes/random")//query troca os valores e passa o que tem que ser
    fun findrandom(@Query("apiKey")apiKey: String=HTTPClient.API_KEY):Call<Joke>
}