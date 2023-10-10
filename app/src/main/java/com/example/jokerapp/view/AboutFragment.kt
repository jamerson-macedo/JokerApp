package com.example.jokerapp.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.os.BuildCompat

import androidx.fragment.app.Fragment
import com.example.jokerapp.R

import com.squareup.picasso.BuildConfig

class AboutFragment  : Fragment(){

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_about,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val version=view.findViewById<TextView>(R.id.txt_version)
        version.text=getString(R.string.build_version,BuildConfig.VERSION_NAME)
    }
}