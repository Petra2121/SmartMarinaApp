package com.profico.smartmarina

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.profico.smartmarina.data.model.*
import java.nio.file.Files.size

class MyReservationsAdapter(
    private var list: List<MyReservations>? = null,
    private val clickListener: (List<MyReservations>) -> Unit
    // val brodovi: Brodovi
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
        // val imena = brodovi.data.get(position)

        //holder.itemView.recyclerShips?.text= imena.nam
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