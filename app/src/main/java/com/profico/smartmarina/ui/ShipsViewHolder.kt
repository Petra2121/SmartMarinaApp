package com.profico.smartmarina

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.profico.smartmarina.data.model.Boats

class ShipsViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
    RecyclerView.ViewHolder(inflater.inflate(R.layout.row_ship_layout, parent, false)) {
    private var mShipNameView: TextView? = null

    init {
        mShipNameView = itemView.findViewById(R.id.ShipName)
    }

    fun bind(ship: Boats) {
        mShipNameView?.text = ship.shipName
        /*val hi= ship.shipType*/
    }

}