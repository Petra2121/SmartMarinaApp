package com.profico.smartmarina.ui

import android.app.DatePickerDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.profico.smartmarina.R
import kotlinx.android.synthetic.main.fragment_home_screen.*
import kotlinx.android.synthetic.main.fragment_payment.*
import java.text.SimpleDateFormat
import java.util.*


/**
 * A simple [Fragment] subclass.
 */
class PaymentFragment : BaseFragment() {

    private val cal: Calendar = Calendar.getInstance()

    override fun getLayout() = R.layout.fragment_payment
    override fun hasToolbar() = false


    override fun setupView() {
        btn_pay.setOnClickListener {
            findNavController().navigate(PaymentFragmentDirections.actionPaymentFragmentToSuccessFragment())
        }
        pickCardDate()
    }

    private val dateSetCard =
        DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
            cal.set(Calendar.YEAR, year)
            cal.set(Calendar.MONTH, monthOfYear)
            cal.set(Calendar.DAY_OF_MONTH, dayOfMonth)
            updateCardDateInView()
        }

    private fun pickCardDate() {
        cardDate.setOnClickListener {
            DatePickerDialog(
                requireContext(), dateSetCard, cal.get(Calendar.YEAR),
                cal.get(Calendar.MONTH),
                cal.get(Calendar.DAY_OF_MONTH)
            ).show()
        }

    }

    private fun updateCardDateInView() {
        val myFormat = "dd/MM/yyyy"
        val sdf = SimpleDateFormat(myFormat, Locale.ITALY)
        cardDate!!.text = sdf.format(cal.getTime())
    }
}





