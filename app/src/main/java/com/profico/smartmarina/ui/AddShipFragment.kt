package com.profico.smartmarina.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.navigation.fragment.findNavController
import com.profico.smartmarina.R
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
            /**m**/ val shipName = shipName.text.toString()
            findNavController().navigate(AddShipFragmentDirections.actionAddShipFragmentToShipsFragment(shipName))
        }
    }


}
