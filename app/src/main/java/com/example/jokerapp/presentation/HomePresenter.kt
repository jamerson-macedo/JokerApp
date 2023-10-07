package com.example.jokerapp.presentation

import android.graphics.Color
import com.example.jokerapp.data.ListCategoryCallBack
import com.example.jokerapp.data.CategoryRemoteDataSource
import com.example.jokerapp.model.Category
import com.example.jokerapp.view.HomeFragment

class HomePresenter(
    private val homeFragment: HomeFragment,
    private val datasource: CategoryRemoteDataSource = CategoryRemoteDataSource()// defino como padrao o data source
) : ListCategoryCallBack {
    // view conecta com o presenter e o presenter se conecta com o view
    fun findallcategories() {
        homeFragment.showprogress()
        datasource.fakeRequest(this)
    }

    override fun onSuccess(response: List<String>) {
        // para fazer um degrade de uma cor a outra
        // é preciso fazer a subtracao do elemento final com o inicial
        val start = 40
        val end = 190
        val dif = (end - start) / response.size
        // // mapeia para o model
        val categories = response.mapIndexed { index, value ->
            val hsv = floatArrayOf(
                start + (dif * index).toFloat(), 100.0f, 100.0f
            )

            Category(value, Color.HSVToColor(hsv).toLong())
        }
        homeFragment.showcategories(categories)
    }

    override fun onError(message: String) {
        homeFragment.showFailure(message)
    }

    override fun onComplete() {
        homeFragment.hideProgress()
    }
}