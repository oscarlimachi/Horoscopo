package com.example.horoscopo

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.horoscopo.data.Horoscope

class HoroscopeAdapter(val items: List<Horoscope>, val onItemClick: (Int) -> Unit): Adapter<HoroscopeViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HoroscopeViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: HoroscopeViewHolder, position: Int
    ) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        return items.size
    }
}


class HoroscopeViewHolder(view: View) : ViewHolder(view){

}
