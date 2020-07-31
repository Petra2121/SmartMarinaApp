package com.profico.smartmarina.ui
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.profico.smartmarina.R
import com.profico.smartmarina.data.Repository
import kotlinx.android.synthetic.main.fragment_add_ship.*
import kotlinx.android.synthetic.main.fragment_home_screen.*

/**
 * A simple [Fragment] subclass.
 */
class AddShipFragment : BaseFragment() {
    val args : AddShipFragmentArgs by navArgs()
    override fun getLayout() = R.layout.fragment_add_ship
    override fun hasToolbar() = false
    override fun setupView() {
        val values = arrayOf(
            "Small",
            "Medium",
            "Big"
        )
        val adapter = ArrayAdapter(
            this.requireActivity(),
            android.R.layout.simple_spinner_item,
            values
        )
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line)
        spinner.adapter = adapter
        spinner.onItemSelectedListener = object: AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {
                /**/
            }
            override fun onItemSelected( parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                if (parent != null) {
                    val selectedSize = parent.getItemAtPosition(position).toString(); //spremljena velicina
                    Toast.makeText(parent.context, selectedSize, Toast.LENGTH_SHORT).show()

                    saveShip.setOnClickListener {
                        val shipNameA = shipName.text.toString()
                        val regnumb = shipRegistration.text.toString()
                        findNavController().navigate(AddShipFragmentDirections.actionAddShipFragmentToShipsFragment(shipNameA, args.arrivalDate, args.departureDate, selectedSize, args.passengerNumber, ""))
                        /*proba*/
                        callAddServer(shipNameA, regnumb, selectedSize, "5d7a514b5d2c12c7449be040")
                    }
                };
            }
        }
    }
}
// Retrofit call example
// Call method in repository -> Repository fun call retrofit
fun callAddServer(boatname: String, regnumber: String, boattype: String, userboat: String) {
    Repository().callAddServer(boatname, regnumber, boattype, userboat)
}