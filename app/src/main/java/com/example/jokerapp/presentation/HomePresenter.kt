package com.example.jokerapp.presentation

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
        // // mapeia para o model
        val categories = response.map { Category(it, 0xff00ff) }
        homeFragment.showcategories(categories)
    }

    override fun onError(message: String) {
        homeFragment.showFailure(message)
    }

    override fun onComplete() {
        homeFragment.hideProgress()
    }
}