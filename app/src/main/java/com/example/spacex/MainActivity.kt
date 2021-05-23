package com.example.spacex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val model: LaunchViewModel by viewModels()
        model.liveLaunchItems.observe(this, {
            buildListView(it)
        })
    }

    private fun buildListView(list: List<LaunchResponse>) {
        recyclerView.adapter = LaunchAdapter(list)
    }
}