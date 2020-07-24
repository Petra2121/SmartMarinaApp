package com.profico.smartmarina.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.profico.smartmarina.R
import kotlinx.android.synthetic.main.fragment_home_screen.*
import kotlinx.android.synthetic.main.fragment_login.*

/**
 * A simple [Fragment] subclass.
 */
class HomeScreenFragment : BaseFragment() {

    override fun getLayout() = R.layout.fragment_home_screen

    override fun hasToolbar() = true

    override fun setupView() {
        /*bbbttt.setOnClickListener {
            findNavController().navigate(HomeScreenFragmentDirections.actionHomeScreenFragmentToShipsFragment(""))
        }*/
    }

}
