package com.profico.smartmarina

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.profico.smartmarina.data.model.DataShips
import com.profico.smartmarina.ui.HomeScreenFragment
import com.profico.smartmarina.ui.ShipsFragmentDirections

import kotlinx.android.synthetic.main.fragment_ships.*

class ListAdapter(private val list: List<DataShips>)
    : RecyclerView.Adapter<ShipsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShipsViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ShipsViewHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: ShipsViewHolder, position: Int) {
        val ship: DataShips = list[position]
        holder.bind(ship)

        holder.itemView.setOnClickListener (object :View.OnClickListener {

            override fun onClick(v: View?) {
                if (position == 1) {
                    val activity = v!!.context as AppCompatActivity
                    val fragmentNeeded = HomeScreenFragment()
                    activity.supportFragmentManager.beginTransaction()
                        .replace(R.id.recyclerShips, fragmentNeeded).addToBackStack(null).commit()
                }
            }
        })

    }

    override fun getItemCount(): Int = list.size

}