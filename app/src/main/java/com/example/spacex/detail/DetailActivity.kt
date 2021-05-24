package com.example.spacex.detail

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.spacex.R

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        val rocketId = intent.getStringExtra("ROCKET_ID").let {
            it ?: "-1"
        }
        val model: DetailViewModel = ViewModelProvider(this, ViewModelFactory(rocketId))[DetailViewModel::class.java]
        model.liveDetailItem.observe(this, {
            findViewById<TextView>(R.id.rocketName).text = "Rocket Name: ${it.name}"
            findViewById<TextView>(R.id.rocketType).text = "Rocket Type: ${it.type}"
        })
    }
}