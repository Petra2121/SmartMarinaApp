package com.profico.smartmarina

import android.os.Build
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.profico.smartmarina.data.model.BoatData
import com.profico.smartmarina.data.model.Boats
import com.profico.smartmarina.data.model.MyReservations
import com.profico.smartmarina.data.model.Reservations
import kotlinx.android.synthetic.main.fragment_home_screen.*
import java.text.SimpleDateFormat
import java.time.format.DateTimeFormatter
import java.util.*

class MyReservationsViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
    RecyclerView.ViewHolder(inflater.inflate(R.layout.row_reservation_layout, parent, false)) {
    private var mReservationNameView: TextView? = null

    init {
        mReservationNameView = itemView.findViewById(R.id.ReservationName)
    }


    fun bind(reservation: MyReservations) {
          //val myFormat = "dd-MM-yyyy"
          var date = reservation.reservationDateOfArrival.toString().subSequence(0,10)

         //val sdf= SimpleDateFormat(myFormat, Locale.ITALY).toString()
        //dateOfArrival!!.text = sdf.format(cal.getTime())
        //mReservationNameView?.text= date.format(reservation.reservationDateOfArrival)
        mReservationNameView?.text = "Name: "+ '\t' + reservation.boat.boatName+'\n' + "Registration: "  + reservation.boat.boatRegistration + '\n'+ "Boat type: "+ reservation.boat.boatType +'\n'+"Reservation type: "+ reservation.reservationType+'\n'+ "Date of arrival: "+ date+'\n'+"Price: " +reservation.reservationTotalPrice + "$"

    }

}