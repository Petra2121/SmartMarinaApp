package com.profico.smartmarina.ui

import android.app.DatePickerDialog
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.profico.smartmarina.R
import kotlinx.android.synthetic.main.fragment_add_ship.*
import kotlinx.android.synthetic.main.fragment_home_screen.*
import kotlinx.android.synthetic.main.fragment_home_screen.dateOfArrival
import kotlinx.android.synthetic.main.fragment_home_screen.dateOfDeparture
import kotlinx.android.synthetic.main.fragment_home_screen.profile
import kotlinx.android.synthetic.main.fragment_new_screen.*
import org.koin.core.KoinComponent
import java.text.SimpleDateFormat
import java.util.*


/**
 * Created by Nikolina on 22/07/2020
 */
class NewScreenFragment : BaseFragment(), KoinComponent {

    private val cal: Calendar = Calendar.getInstance()

    val args : NewScreenFragmentArgs by navArgs()

    override fun getLayout() = R.layout.fragment_new_screen

    override fun hasToolbar() = false

    override fun setupView() {
        availability.setOnClickListener {
            findNavController().navigate(NewScreenFragmentDirections.actionNewScreenFragmentToMapFragment(args.shipName2, args.arrivalDate, args.departureDate, args.shipSize, args.passengerNumber))
        }

        profile.setOnClickListener {
            findNavController().navigate(NewScreenFragmentDirections.actionNewScreenFragmentToProfileFragment())
        }

        //args.shipSize je odabrana velicina broda
        if(args.shipName2!="")
            shippp.text = args.shipName2

        if(args.arrivalDate!="")
            dateA.text=args.arrivalDate.toString()

        if(args.departureDate!="")
            dateD.text=args.departureDate.toString()
    }



}