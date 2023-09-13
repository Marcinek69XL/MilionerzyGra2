package com.example.milionerzygra2.recycleadapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.milionerzygra2.R
import com.example.milionerzygra2.databinding.ActivityWynikiBinding
import com.example.milionerzygra2.models.WynikModel


class LeaderboardAdapter(private val context: Context, private val leaderboardList: List<WynikModel>) :
    RecyclerView.Adapter<LeaderboardAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvPozycja: TextView = itemView.findViewById(R.id.tvPozycja)
        val tvNazwa: TextView = itemView.findViewById(R.id.tvNazwa)
        val tvWynik: TextView = itemView.findViewById(R.id.tvWynik)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.wynik_recycleview_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val wynik = leaderboardList[position]
        holder.tvPozycja.text = (position + 1).toString()+ ".";
        holder.tvNazwa.text = wynik.nazwaUzytkownika
        holder.tvWynik.text = wynik.kwotaWygrana.toString()
    }

    override fun getItemCount(): Int {
        return leaderboardList.size
    }
}
