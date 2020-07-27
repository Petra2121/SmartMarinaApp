package com.profico.smartmarina.ui

import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
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

        /*** ovo san minjala ***/

        spinner.onItemSelectedListener = object:

            AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {
                /**/
            }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                if (parent != null) {
                    var selectedSize = parent.getItemAtPosition(position).toString(); //spremljena velicina
                    Toast.makeText(parent.getContext(), selectedSize,Toast.LENGTH_SHORT).show()

                };
            }

        }
        /*** do ovoga ***/
        saveShip.setOnClickListener {
            val shipNameA = shipName.text.toString()
            findNavController().navigate(AddShipFragmentDirections.actionAddShipFragmentToShipsFragment(shipNameA))
        }

    }
}
