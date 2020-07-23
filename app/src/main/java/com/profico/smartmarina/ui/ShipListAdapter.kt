package com.profico.smartmarina

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.profico.smartmarina.data.model.DataShips

class ListAdapter(private val list: List<DataShips>)
    : RecyclerView.Adapter<ShipsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShipsViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ShipsViewHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: ShipsViewHolder, position: Int) {
        val ship: DataShips = list[position]
        holder.bind(ship)

        holder.itemView.setOnClickListener {
            if (position == 0) {
                val shipNm = list[position].toString()
                Log.d("TAG", "$shipNm")
            }

            if (position == 1) {

            }

            if (position == 2) {

            }

        }
    }

    override fun getItemCount(): Int = list.size

}