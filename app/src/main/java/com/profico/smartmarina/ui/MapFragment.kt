package com.profico.smartmarina.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.profico.smartmarina.R
import kotlinx.android.synthetic.main.fragment_map.*
import org.koin.core.KoinComponent

/**
 * A simple [Fragment] subclass.
 */
class MapFragment : BaseFragment(){
    override fun getLayout() = R.layout.fragment_map
    override fun hasToolbar() = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_map, container, false)
    }


    override fun setupView() {
        map_button.setOnClickListener {
                findNavController().navigate(MapFragmentDirections.actionMapFragmentToPaymentFragment())
        }
    }

}
