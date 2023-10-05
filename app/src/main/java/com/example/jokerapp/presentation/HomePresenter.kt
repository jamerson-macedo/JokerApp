package com.example.jokerapp.presentation

import android.os.Handler
import android.os.Looper
import com.example.jokerapp.model.Category
import com.example.jokerapp.view.CategoryItem
import com.example.jokerapp.view.HomeFragment

class HomePresenter(private val homeFragment: HomeFragment) {
    // view conecta com o presenter e o presenter se conecta com o view
    fun findallcategories() {
        homeFragment.showprogress()
        fakeRequest()

    }

    fun onSucess(response: List<String>) {
        // // mapeia para o model
        val categories = response.map { Category(it,0xffff0000) }
        homeFragment.showcategories(categories)
        }




    fun onError(message: String) {
        homeFragment.showFailure(message)
    }

    fun onComplete() {
        homeFragment.hideProgress()

    }

    // simula uma requisiçào
    fun fakeRequest() {
        Handler(Looper.getMainLooper()).postDelayed({
            val response = arrayListOf(
               "categoria","engra;ado","humor"

            )

            //onError("falha no servidor")
            onSucess(response)
            onComplete()

        }, 2000)

    }
}