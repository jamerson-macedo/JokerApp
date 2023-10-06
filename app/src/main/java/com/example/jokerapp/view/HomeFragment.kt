package com.example.jokerapp.view

import android.os.Bundle
import android.os.Message
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.example.jokerapp.R
import com.example.jokerapp.data.CategoryRemoteDataSource
import com.example.jokerapp.model.Category
import com.example.jokerapp.presentation.HomePresenter
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.GroupieAdapter

class HomeFragment : Fragment() {

    private lateinit var presenter: HomePresenter
    private lateinit var progressBar: ProgressBar
    val adapter = GroupieAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // referencia do presentr

        presenter = HomePresenter(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    // dps que a view é criada
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        progressBar = view.findViewById(R.id.bar_progress)
        val recyclerView = view.findViewById<RecyclerView>(R.id.rv_main)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        presenter.findallcategories()
        recyclerView.adapter = adapter


    }

    fun showcategories(categories: List<Category>) {
        // adiciona a o adapter
        Log.i("antes",categories.toString())
        val response=categories.map { CategoryItem(it) }
        Log.i("depois",response.toString())
        adapter.addAll(response)
        adapter.notifyDataSetChanged()


    }

    fun showprogress() {
        progressBar.visibility = View.VISIBLE

    }

    fun hideProgress() {
        progressBar.visibility = View.GONE
    }
    fun showFailure(message: String){

        Toast.makeText(context,message,Toast.LENGTH_SHORT).show()
    }


}