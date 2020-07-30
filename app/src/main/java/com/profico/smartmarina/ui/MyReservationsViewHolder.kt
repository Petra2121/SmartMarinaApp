package com.profico.smartmarina

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.profico.smartmarina.data.model.BoatData
import com.profico.smartmarina.data.model.Boats
import com.profico.smartmarina.data.model.MyReservations
import com.profico.smartmarina.data.model.Reservations

class MyReservationsViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
    RecyclerView.ViewHolder(inflater.inflate(R.layout.row_reservation_layout, parent, false)) {
    private var mReservationNameView: TextView? = null

    init {
        mReservationNameView = itemView.findViewById(R.id.ReservationName)
    }

    fun bind(reservation: MyReservations) {
        mReservationNameView?.text = "Name: "+ '\t' + reservation.boat.boatName+'\n' + "Registration: "  + reservation.boat.boatRegistration + '\n'+ "Boat type: "+ reservation.boat.boatType +'\n'+"Reservation type: "+ reservation.reservationType+'\n'+ "Date of arrival: "+ reservation.reservationDateOfArrival.format()+'\n'+"Price: " +reservation.reservationTotalPrice

    }

}