package com.example.startkotlin2.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.startkotlin2.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var viewModel: MainViewModel
    lateinit var adapter: NotesRVAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        my_recycler_view.layoutManager = GridLayoutManager(this, 2)
        adapter = NotesRVAdapter()
        my_recycler_view.adapter = adapter


        viewModel.viewState().observe(this, Observer{ value ->
            value?.let { adapter.notes = it.notes }
        })
    }
}