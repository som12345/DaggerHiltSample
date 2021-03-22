package com.example.daggerhiltsample.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.daggerhiltsample.R
import com.example.daggerhiltsample.model.Android
import com.example.daggerhiltsample.model.ResponseEnum
import com.example.daggerhiltsample.viewmodel.OsListViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val osListViewModel: OsListViewModel by viewModels()
    private lateinit var adapter: OsListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupUI()
        setupObserver()
    }

    private fun setupUI() {
        recylerview.layoutManager = LinearLayoutManager(this)
        adapter = OsListAdapter(arrayListOf())
        recylerview.addItemDecoration(
            DividerItemDecoration(
                recylerview.context,
                (recylerview.layoutManager as LinearLayoutManager).orientation
            )
        )
        recylerview.adapter = adapter
    }

    private fun setupObserver() {
        osListViewModel.listOs.observe(this, Observer {
            when (it.status) {
                ResponseEnum.SUCCESS -> {
                    progressBar.visibility = View.GONE
                    it.data?.let { android -> renderList(android.android) }
                    recylerview.visibility = View.VISIBLE
                }
                ResponseEnum.LOADING -> {
                    progressBar.visibility = View.VISIBLE
                    recylerview.visibility = View.GONE
                }
                ResponseEnum.FAILURE -> {
                    progressBar.visibility = View.GONE
                    Toast.makeText(this, it.message, Toast.LENGTH_LONG).show()
                }
            }
        })
    }

    private fun renderList(android: List<Android>) {
        adapter.addData(android)
        adapter.notifyDataSetChanged()
    }
}