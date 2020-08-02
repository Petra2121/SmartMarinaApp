package com.profico.smartmarina.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.profico.smartmarina.R
import com.profico.smartmarina.data.Repository
import com.profico.smartmarina.data.model.BoatData
import kotlinx.android.synthetic.main.fragment_my_reservations.*

/**
 * A simple [Fragment] subclass.
 */
class MyReservationsFragment : BaseFragment() {

    var reservationsAdapter: MyReservationsAdapter?= null

    override fun getLayout(): Int = R.layout.fragment_my_reservations

    override fun hasToolbar(): Boolean = false

    override fun setupView() {
        recyclerReservations.apply {
            // set a LinearLayoutManager to handle Android
            // RecyclerView behavior
            layoutManager = LinearLayoutManager(activity)
            //set the custom adapter to the RecyclerView
            reservationsAdapter = MyReservationsAdapter{

//                findNavController().navigate(.actionShipsFragmentToNewScreenFragment(it.toString(),
//                    args.arrivalDate, args.departureDate, args.shipSize.toString()))
            }

            adapter = reservationsAdapter
        }
        getMyReservations()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retainInstance = true
    }

    companion object {
        fun newInstance(): MyReservationsFragment = MyReservationsFragment()
    }
    fun getMyReservations() {
        Repository().getMyReservations("") {
            val tmpList : MutableList<BoatData>

//            it.forEach {
//                var sve : MutableList<Reservations> ?= null
//                if (sve != null) {
//                    sve.addAll(listOf(it))
//                }
//               println("gsd"+sve)
//                if (sve != null) {
//                    sve.forEach{
//                        var lista : MutableList<BoatData> ? =null
//                        lista.addAll()
//                        reservationsAdapter?.notifyDataChange(lista)
//                    }
//                }
//                //    sve.add()}
//
//            }}
            reservationsAdapter?.notifyDataChange(it)
        }
    }}


