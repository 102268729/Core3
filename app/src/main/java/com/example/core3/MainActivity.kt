package com.example.core03

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bignerdranch.android.core3.Location
import com.example.core3.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val numberList = findViewById<RecyclerView>(R.id.RecycleView)

        val data = mutableListOf<Location>()
        numberList.layoutManager = LinearLayoutManager(this)

        resources.openRawResource(R.raw.au_locations).bufferedReader()
            .forEachLine {
                val value = it.split(",")
                data.add(Location(value[0], value[1].toFloat(), value[2].toFloat(), value[3]))
            }

        numberList.adapter = Adapter(data)

    }


}