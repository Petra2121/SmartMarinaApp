package com.profico.smartmarina.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.profico.smartmarina.data.model.*

class MyReservationsAdapter(
    private var list: List<MyReservations>? = null,
    private val clickListener: (List<MyReservations>) -> Unit
    )
    : RecyclerView.Adapter<MyReservationsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyReservationsViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return MyReservationsViewHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: MyReservationsViewHolder, position: Int) {
        list?.get(position)?.let {ship ->
            holder.bind(ship)
            holder.itemView.setOnClickListener {
                clickListener.invoke(listOf(ship))
            }
        }
    }

    override fun getItemCount(): Int {
        return if (list==null)
            0;
        else
            list!!.size
    }

    fun notifyDataChange(list: List<MyReservations>) {
        this.list = list
        notifyDataSetChanged()
    }

}