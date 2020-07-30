package com.profico.smartmarina.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.profico.smartmarina.ListAdapter
import com.profico.smartmarina.R
import com.profico.smartmarina.data.Repository
import com.profico.smartmarina.data.model.Boats
import kotlinx.android.synthetic.main.fragment_add_ship.*
import com.profico.smartmarina.data.model.DataShips
import kotlinx.android.synthetic.main.fragment_add_ship.shipName
import kotlinx.android.synthetic.main.fragment_add_ship.view.*
import kotlinx.android.synthetic.main.fragment_home_screen.view.*
import kotlinx.android.synthetic.main.fragment_ships.*

/**
 * A simple [Fragment] subclass.
 */
class ShipsFragment : BaseFragment() {

    val args: ShipsFragmentArgs by navArgs()

    var shipsAdapter: ListAdapter? = null

    override fun getLayout(): Int = R.layout.fragment_ships

    override fun hasToolbar(): Boolean = false

    override fun setupView() {
        btnAddNewShip.setOnClickListener {
            findNavController().navigate(ShipsFragmentDirections.actionShipsFragmentToAddShipFragment("", args.arrivalDate, args.departureDate,
                args.shipSize.toString()
            ))
        }

        recyclerShips.apply {
            // set a LinearLayoutManager to handle Android
            // RecyclerView behavior
            layoutManager = LinearLayoutManager(activity)
             //set the custom adapter to the RecyclerView
            shipsAdapter = ListAdapter{

                findNavController().navigate(ShipsFragmentDirections.actionShipsFragmentToNewScreenFragment(it.toString(),
                    args.arrivalDate, args.departureDate, args.shipSize.toString()))
            }

            adapter = shipsAdapter
        }

        //if (args.shipName2 != "") {
            //.add(DataShips(args.shipName2))



       getShipName()
    }

//    private val ShipsList = mutableListOf(
//        DataShips("National Treasure"),
//        DataShips("Thunder"),
//        DataShips("Blue Ocean")
//    )

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

//     fun fetchJson(){
//        val url ="https://api.smart-marina.proficodev.com/boats"
//        val request = Request.Builder().url(url).build()
//        val client = OkHttpClient()
//
//        client.newCall(request).enqueue(object: Callback{
//            override fun onResponse(call: Call, response: Response) {
//                val body = response?.body()?.string()
//                println(body)
//                val gson = GsonBuilder().create()
//                val brodovi = gson.fromJson(body, Brodovi ::class.java)
//
//
//             //   recyclerShips.adapter = ListAdapter (brodovi)
//
//            }
//            override fun onFailure(call: Call, e: IOException) {
//                println("Failed to execute request")
//            }
//        })
//
//    }
//
//}
//class Brodovi (val data: List<Ime>)
//class Ime (val id: Int, val name: String, val registration_number: String, val type: String)
