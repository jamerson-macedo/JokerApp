package com.example.jokerapp.data

import android.os.Handler
import android.os.Looper
import com.example.jokerapp.model.Joke
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.RuntimeException

class JokerRemoteDataSource {
    // fakerequest espera alguem que imoplementa o callback
    fun findby(categoryname: String, callBack: JokeCallBack) {
        // pegando nossa interface
        HTTPClient.retrofit().create(ChuckNorrisAPI::class.java).findBy(categoryname)
            .enqueue(object : Callback<Joke?> {
                override fun onResponse(call: Call<Joke?>, response: Response<Joke?>) {
                    if(response.isSuccessful){
                        val joke=response.body()
                        // se vinher algo manda, se n manda uma lista vazia
                        callBack.onSuccess(joke ?: throw RuntimeException("joke não encontrado"))

                    }else{
                        val erro=response.errorBody()?.string()
                        // quando o servidor estiver fora do ar
                        callBack.onError(erro ?: "ERRO DESCONHECIDO")

                    }

                    callBack.onComplete()
                }

                override fun onFailure(call: Call<Joke?>, t: Throwable) {
                    callBack.onError(t.message ?:"ERRO INTERNO")
                    callBack.onComplete()
                }
            })

    }
}
