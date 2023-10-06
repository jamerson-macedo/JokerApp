package com.example.jokerapp.data

import android.os.Handler
import android.os.Looper
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CategoryRemoteDataSource {
    // fakerequest espera alguem que imoplementa o callback
    fun fakeRequest(callBack: ListCategoryCallBack) {
        // pegando nossa interface
        HTTPClient.retrofit().create(ChuckNorrisAPI::class.java).findallcategories().enqueue(object : Callback<List<String>?> {
            override fun onResponse(call: Call<List<String>?>, response: Response<List<String>?>) {
                if(response.isSuccessful){
                val obj=response.body()
                    // se vinher algo manda, se n manda uma lista vazia
                callBack.onSuccess(obj ?: emptyList())

                }else{
                    val erro=response.errorBody()?.string()
                    // quando o servidor estiver fora do ar
                    callBack.onError(erro ?: "ERRO DESCONHECIDO")

                }

                callBack.onComplete()
            }

            override fun onFailure(call: Call<List<String>?>, t: Throwable) {
                callBack.onError(t.message ?:"ERRO INTERNO")
                callBack.onComplete()
            }
        })


    }
}