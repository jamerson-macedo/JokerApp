package com.example.jokerapp.presentation

import android.graphics.Color
import com.example.jokerapp.data.ListCategoryCallBack
import com.example.jokerapp.data.CategoryRemoteDataSource
import com.example.jokerapp.data.JokeCallBack
import com.example.jokerapp.data.JokerDayRemoteDataSource
import com.example.jokerapp.data.JokerRemoteDataSource
import com.example.jokerapp.model.Category
import com.example.jokerapp.model.Joke
import com.example.jokerapp.view.HomeFragment
import com.example.jokerapp.view.JokeDayFragment
import com.example.jokerapp.view.JokerFragment

class JokerDayPresenter(
    private val jokerdayFragment: JokeDayFragment,
    private val datasource: JokerDayRemoteDataSource = JokerDayRemoteDataSource()// defino como padrao o data source
) : JokeCallBack {
    // view conecta com o presenter e o presenter se conecta com o view
    fun findrandom() {
        jokerdayFragment.showprogress()
        datasource.findrandom(this)
    }

    override fun onSuccess(response: Joke) {


        jokerdayFragment.showjoker(response)
    }

    override fun onError(message: String) {
        jokerdayFragment.showFailure(message)
    }

    override fun onComplete() {
        jokerdayFragment.hideProgress()
    }
}