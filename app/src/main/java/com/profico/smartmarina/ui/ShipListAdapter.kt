package com.profico.smartmarina

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.profico.smartmarina.data.model.Boats
import com.profico.smartmarina.data.model.DataShips
import java.nio.file.Files.size

class ListAdapter(
    private var list: List<Boats>? = null,
    private val clickListener: (List<Boats>) -> Unit
   // val brodovi: Brodovi
)
    : RecyclerView.Adapter<ShipsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShipsViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ShipsViewHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: ShipsViewHolder, position: Int) {
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

    fun notifyDataChange(list: List<Boats>) {
        this.list = list
        notifyDataSetChanged()
    }


}