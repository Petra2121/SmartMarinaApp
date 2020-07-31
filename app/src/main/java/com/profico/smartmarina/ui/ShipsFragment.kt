package com.profico.smartmarina.ui

import android.os.Bundle
import android.system.Os.bind
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.profico.smartmarina.R
import com.profico.smartmarina.data.Repository
import com.profico.smartmarina.data.model.Boats
import kotlinx.android.synthetic.main.fragment_add_ship.view.*
import kotlinx.android.synthetic.main.fragment_new_screen.view.*
import kotlinx.android.synthetic.main.fragment_ships.*
import org.koin.android.ext.android.bind
import org.koin.ext.getScopeId

/**
 * A simple [Fragment] subclass.
 */
class ShipsFragment : BaseFragment() {

    val args: ShipsFragmentArgs by navArgs()

    var shipsAdapter: ListAdapter? = null
    var shipSize2 : String = "Small"

    var newList : List<Boats>? = null
    var listOfTypes : List<Boats>? = null
    var listOfTipovi : MutableList<String>? = null

    override fun getLayout(): Int = R.layout.fragment_ships

    override fun hasToolbar(): Boolean = false

    override fun setupView() {
        btnAddNewShip.setOnClickListener {
            findNavController().navigate(ShipsFragmentDirections.actionShipsFragmentToAddShipFragment("", args.arrivalDate, args.departureDate,
                args.shipSize.toString(), args.passengerNumber))
        }

        recyclerShips.apply {
            // set a LinearLayoutManager to handle Android
            // RecyclerView behavior
            layoutManager = LinearLayoutManager(activity)
             //set the custom adapter to the RecyclerView
            shipsAdapter = ListAdapter{

                findNavController().navigate(ShipsFragmentDirections.actionShipsFragmentToNewScreenFragment(it.shipName,
                    args.arrivalDate, args.departureDate, it.shipType, args.passengerNumber))
            }

            adapter = shipsAdapter
        }

        //if (args.shipName2 != "") {
            //.add(DataShips(args.shipName2))



       getShipName()
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retainInstance = true
    }

    companion object {
        fun newInstance(): ShipsFragment = ShipsFragment()
    }
    fun getShipName() {
        Repository().getShipName("") {
            shipsAdapter?.notifyDataChange(it)
        }
    }
}


