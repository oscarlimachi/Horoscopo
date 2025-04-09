package com.example.horoscopo.activities

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.horoscopo.R
import com.example.horoscopo.data.HoroscopeProvider

class DetailActivity : AppCompatActivity() {

    lateinit var nameTextView: TextView
    lateinit var dateTextView: TextView
    lateinit var iconImageView: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detail)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        nameTextView = findViewById(R.id.nameTextView)
        dateTextView = findViewById(R.id.dateTextView)
        iconImageView = findViewById(R.id.iconImageView)

        val id=intent.getStringExtra("HOROSCOPE_ID")!!
        val horoscope = HoroscopeProvider.getById(id)!!
        Toast.makeText(this,getString(horoscope.name), Toast.LENGTH_SHORT).show()
        nameTextView.setText(horoscope.name)
        dateTextView.setText(horoscope.dates)
        iconImageView.setImageResource(horoscope.icon)

    }
}