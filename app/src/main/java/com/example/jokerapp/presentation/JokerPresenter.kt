package com.example.jokerapp.presentation

import android.graphics.Color
import com.example.jokerapp.data.ListCategoryCallBack
import com.example.jokerapp.data.CategoryRemoteDataSource
import com.example.jokerapp.data.JokeCallBack
import com.example.jokerapp.data.JokerRemoteDataSource
import com.example.jokerapp.model.Category
import com.example.jokerapp.model.Joke
import com.example.jokerapp.view.HomeFragment
import com.example.jokerapp.view.JokerFragment

class JokerPresenter(
    private val jokerFragment: JokerFragment,
    private val datasource: JokerRemoteDataSource = JokerRemoteDataSource()// defino como padrao o data source
) : JokeCallBack {
    // view conecta com o presenter e o presenter se conecta com o view
    fun findby(categoryname: String) {
        jokerFragment.showprogress()
        datasource.findby(categoryname, this)
    }

    override fun onSuccess(response: Joke) {


        jokerFragment.showjoker(response)
    }

    override fun onError(message: String) {
        jokerFragment.showFailure(message)
    }

    override fun onComplete() {
        jokerFragment.hideProgress()
    }
}