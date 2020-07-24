package com.profico.smartmarina.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.profico.smartmarina.ListAdapter
import com.profico.smartmarina.R
import com.profico.smartmarina.data.model.DataShips
import kotlinx.android.synthetic.main.fragment_ships.*

/**
 * A simple [Fragment] subclass.
 */
class ShipsFragment : BaseFragment() {

    val args : ShipsFragmentArgs by navArgs()

    var shipsAdapter : ListAdapter? = null

    override fun getLayout(): Int = R.layout.fragment_ships

    override fun hasToolbar(): Boolean = false

    override fun setupView() {
        btnAddNewShip.setOnClickListener {
            findNavController().navigate(ShipsFragmentDirections.actionShipsFragmentToAddShipFragment())
        }

        recyclerShips.apply {
            // set a LinearLayoutManager to handle Android
            // RecyclerView behavior
            layoutManager = LinearLayoutManager(activity)
            // set the custom adapter to the RecyclerView
            shipsAdapter = ListAdapter(ShipsList) {
                findNavController().navigate(ShipsFragmentDirections.actionShipsFragmentToHomeScreenFragment())

            }

            adapter = shipsAdapter
        }

        if (args.shipName2 != "") {
            ShipsList.add(DataShips(args.shipName2))
            shipsAdapter?.notifyDataChange(ShipsList)
        }
    }

    private val ShipsList = mutableListOf(
        DataShips("National Treasure"),
        DataShips("Thunder"),
        DataShips("Blue Ocean")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retainInstance = true
    }

    companion object {
        fun newInstance(): ShipsFragment = ShipsFragment()
    }

}
