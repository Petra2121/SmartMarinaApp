package com.profico.smartmarina.ui

import android.app.DatePickerDialog
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.profico.smartmarina.R
import kotlinx.android.synthetic.main.fragment_add_ship.*
import kotlinx.android.synthetic.main.fragment_home_screen.*
import org.koin.core.KoinComponent
import java.text.SimpleDateFormat
import java.util.*


/**
 * Created by Nikolina on 22/07/2020
 */
class HomeScreenFragment : BaseFragment(), KoinComponent {

    private val cal: Calendar = Calendar.getInstance()

    override fun getLayout() = R.layout.fragment_home_screen

    override fun hasToolbar() = false

    override fun setupView() {
        pickArrivalDate()
        pickDepartureDate()

        profile.setOnClickListener {
            findNavController().navigate(HomeScreenFragmentDirections.actionHomeScreenFragmentToProfileFragment())
        }

        ship.setOnClickListener {
            findNavController().navigate(HomeScreenFragmentDirections.actionHomeScreenFragmentToShipsFragment("", dateOfArrival.text.toString(), dateOfDeparture.text.toString()))
        }
    }

    private val dateSetListenerArrival =
        DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
            cal.set(Calendar.YEAR, year)
            cal.set(Calendar.MONTH, monthOfYear)
            cal.set(Calendar.DAY_OF_MONTH, dayOfMonth)
            updateArrivalDateInView()
        }

    private val dateSetListenerDeparture =
        DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
            cal.set(Calendar.YEAR, year)
            cal.set(Calendar.MONTH, monthOfYear)
            cal.set(Calendar.DAY_OF_MONTH, dayOfMonth)
            updateDepartureDateInView()
        }

    private fun pickArrivalDate() { //otvara se izbornik (kalendar)
        dateOfArrival.setOnClickListener {
            DatePickerDialog(
                requireContext(), dateSetListenerArrival, cal.get(Calendar.YEAR),
                cal.get(Calendar.MONTH),
                cal.get(Calendar.DAY_OF_MONTH)
            ).show()
        }
    }

    private fun pickDepartureDate() {
        dateOfDeparture.setOnClickListener {
            DatePickerDialog(
                requireContext(), dateSetListenerDeparture, cal.get(Calendar.YEAR),
                cal.get(Calendar.MONTH),
                cal.get(Calendar.DAY_OF_MONTH)
            ).show()
        }

    }

    private fun updateArrivalDateInView(){ //da bi se datum prikaza u button
        val myFormat = "dd/MM/yyyy"
        val sdf = SimpleDateFormat(myFormat, Locale.ITALY)
        dateOfArrival!!.text = sdf.format(cal.getTime())
    }

    private fun updateDepartureDateInView() {
        val myFormat = "dd/MM/yyyy"
        val sdf = SimpleDateFormat(myFormat, Locale.ITALY)
        dateOfDeparture!!.text = sdf.format(cal.getTime())
    }

}