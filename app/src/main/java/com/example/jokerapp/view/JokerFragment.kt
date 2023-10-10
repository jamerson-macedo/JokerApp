package com.example.jokerapp.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import com.example.jokerapp.R
import com.example.jokerapp.model.Category
import com.example.jokerapp.model.Joke
import com.example.jokerapp.presentation.HomePresenter
import com.example.jokerapp.presentation.JokerPresenter
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.squareup.picasso.Picasso

class JokerFragment : Fragment() {
    private lateinit var presenter: JokerPresenter
    private lateinit var progressBar: ProgressBar
    private lateinit var text_joker: TextView
    private lateinit var img_joker:ImageView
    companion object {

        const val CATEGORY_KEY = "category"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // referencia do presentr

        presenter = JokerPresenter(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_joker, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val categoryname = arguments?.getString(CATEGORY_KEY)!!
        progressBar=view.findViewById(R.id.bar_progress)
        text_joker=view.findViewById(R.id.txt_joke)
        img_joker=view.findViewById(R.id.img_joke)
        view.findViewById<FloatingActionButton>(R.id.fab).setOnClickListener{
            presenter.findby(categoryname)
        }


        Log.i("teste", categoryname.toString())
        // chamei a activity pq a toolbar esta nela
        activity?.findViewById<Toolbar>(R.id.toolbar)?.title = categoryname

        presenter.findby(categoryname)


    }
    fun showjoker(joker: Joke) {
        text_joker.text=joker.text
        Picasso.get().load(joker.iconUrl).into(img_joker);
    }

    fun showprogress() {
        progressBar.visibility = View.VISIBLE

    }

    fun hideProgress() {
        progressBar.visibility = View.GONE
    }

    fun showFailure(message: String) {

        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }

}