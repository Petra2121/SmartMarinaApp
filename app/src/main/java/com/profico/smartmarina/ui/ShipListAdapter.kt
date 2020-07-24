package com.profico.smartmarina

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.profico.smartmarina.data.model.DataShips

class ListAdapter(
    private var list: List<DataShips>,
    private val clickListener: (DataShips) -> Unit
)
    : RecyclerView.Adapter<ShipsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShipsViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ShipsViewHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: ShipsViewHolder, position: Int) {
        val ship: DataShips = list[position]
        holder.bind(ship)

        holder.itemView.setOnClickListener {
            clickListener.invoke(ship)
        }
    }

    override fun getItemCount(): Int = list.size

    fun notifyDataChange(list: List<DataShips>) {
        this.list = list
        notifyDataSetChanged()
    }
}