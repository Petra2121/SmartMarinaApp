package com.profico.smartmarina.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.profico.smartmarina.R
import com.profico.smartmarina.data.model.DataShips
import kotlinx.android.synthetic.main.fragment_add_ship.*
import kotlinx.android.synthetic.main.fragment_ships.*

/**
 * A simple [Fragment] subclass.
 */
class ShipsFragment : BaseFragment() {

    override fun getLayout(): Int = R.layout.fragment_ships

    override fun hasToolbar(): Boolean = false

    override fun setupView() {

        btnAddNewShip.setOnClickListener {
            findNavController().navigate(ShipsFragmentDirections.actionShipsFragmentToAddShipFragment())
        }
    }

    private val ShipsList = listOf(
        DataShips("National Treasure"),
        DataShips("Thunder"),
        DataShips("Blue Ocean")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retainInstance = true
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerShips.apply {
            // set a LinearLayoutManager to handle Android
            // RecyclerView behavior
            layoutManager = LinearLayoutManager(activity)
            // set the custom adapter to the RecyclerView
            adapter = com.profico.smartmarina.ListAdapter(ShipsList)
        }
    }

    companion object {
        fun newInstance(): ShipsFragment = ShipsFragment()
    }

}
