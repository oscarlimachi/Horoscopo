package com.example.horoscopo.activities

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.horoscopo.HoroscopeAdapter
import com.example.horoscopo.R
import com.example.horoscopo.data.Horoscope
import com.example.horoscopo.data.HoroscopeProvider

class MainActivity : AppCompatActivity() {
    val horoscopeList = HoroscopeProvider.getAll()
    lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        recyclerView=findViewById(R.id.recyclerview)
        val adapter= HoroscopeAdapter(horoscopeList, { position ->
            val horoscope = horoscopeList[position]
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("HOROSCOPE_ID",horoscope.id)
            startActivity(intent)
        })
        recyclerView.adapter=adapter
        recyclerView.layoutManager= LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false)

    }



}