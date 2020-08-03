package com.profico.smartmarina.ui

import android.app.DatePickerDialog
import android.text.TextUtils
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.profico.smartmarina.R
import kotlinx.android.synthetic.main.fragment_payment.*
import java.text.SimpleDateFormat
import java.util.*


/**
 * A simple [Fragment] subclass.
 */
class PaymentFragment : BaseFragment() {

    val args : PaymentFragmentArgs by navArgs()

    private val cal: Calendar = Calendar.getInstance()

    override fun getLayout() = R.layout.fragment_payment
    override fun hasToolbar() = false


    override fun setupView() {
        btn_pay.setOnClickListener {
            if( TextUtils.isEmpty(cardNumber.text)) {
                cardNumber.error = "Card number is required!";
            }
            else if( TextUtils.isEmpty(cardCcv.text)) {
                cardCcv.error = "CCV is required!";
            }
            else if (cardDate!!.text == ""){
                cardDate.error = "Date is required!"
            }
            else if( TextUtils.isEmpty(cardName.text)) {
                cardName.error = "First name is required!";
            }
            else {
                findNavController().navigate(PaymentFragmentDirections.actionPaymentFragmentToSuccessFragment(args.resId, args.arrivalDate, args.departureDate))
            }
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
            val datePicker = DatePickerDialog(
                requireContext(), dateSetCard, cal.get(Calendar.YEAR),
                cal.get(Calendar.MONTH),
                cal.get(Calendar.DAY_OF_MONTH)
            )
            datePicker.datePicker.minDate = Calendar.getInstance().timeInMillis
            datePicker.show()
        }
    }

    private fun updateCardDateInView() {
        val myFormat = "dd-MM-yyyy"
        val sdf = SimpleDateFormat(myFormat, Locale.ITALY)
        cardDate!!.text = sdf.format(cal.time)
    }
}





