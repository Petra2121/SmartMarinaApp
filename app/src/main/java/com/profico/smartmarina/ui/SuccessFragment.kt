package com.profico.smartmarina.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.profico.smartmarina.R
import androidx.navigation.fragment.findNavController
import com.profico.smartmarina.data.Repository
import com.profico.smartmarina.data.model.Dokovi
import com.profico.smartmarina.data.model.Reservation
import kotlinx.android.synthetic.main.fragment_profile.*
import kotlinx.android.synthetic.main.fragment_success.*

/**
 * A simple [Fragment] subclass.
 */
class SuccessFragment : BaseFragment() {
    val args : SuccessFragmentArgs by navArgs()
    var rezervacija: Reservation? = null
    override fun getLayout() = R.layout.fragment_success

    override fun hasToolbar() = false

    
    override fun setupView() {
        getReservation(args.resId)

        ok_button.setOnClickListener {
            findNavController().navigate(SuccessFragmentDirections.actionSuccessFragmentToProfileFragment())
        }
    }

    fun getReservation (id: String){
        Repository().getReservation(id){
            rezervacija = it

            reservationNum2.text = rezervacija!!.id2
            boatReg2.text = rezervacija!!.boatRegistrationNumber2
            dockID2.text = rezervacija!!.dockNumber2
            dateASuc2.text = rezervacija!!.dateOfArrival2
            dateDSuc2.text = rezervacija!!.dateOfDeparture2
            priceSuc2.text = rezervacija!!.totalPrice2
        }
    }
}


