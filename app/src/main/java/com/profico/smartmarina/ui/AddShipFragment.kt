package com.profico.smartmarina.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.navigation.fragment.findNavController
import com.profico.smartmarina.R
import com.profico.smartmarina.data.Repository
import kotlinx.android.synthetic.main.fragment_add_ship.*

/**
 * A simple [Fragment] subclass.
 */
class AddShipFragment : BaseFragment() {

    override fun getLayout() = R.layout.fragment_add_ship

    override fun hasToolbar() = false

    override fun setupView() {

        val values = arrayOf(
            "Small",
            "Medium",
            "Large"
        )
        val adapter = ArrayAdapter(
            this.requireActivity(),
            android.R.layout.simple_spinner_item,
            values
        )
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line)
        spinner.adapter = adapter

        saveShip.setOnClickListener {
            val shipNameA = shipName.text.toString()
            findNavController().navigate(AddShipFragmentDirections.actionAddShipFragmentToShipsFragment(shipNameA))
        }




        /*Proba pisanja podataka u bazu*/
        val probaImena = shipName.text.toString()

    }

}

// Retrofit call example
// Call method in repository -> Repository fun call retrofit
fun callAddServer() {
    Repository().callAddServer("")
}