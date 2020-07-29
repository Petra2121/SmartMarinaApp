package com.profico.smartmarina.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.profico.smartmarina.R
import kotlinx.android.synthetic.main.fragment_home_screen.*
import kotlinx.android.synthetic.main.fragment_profile.*

/**
 * A simple [Fragment] subclass.
 */
class ProfileFragment : BaseFragment() {

    override fun getLayout() = R.layout.fragment_profile

    override fun hasToolbar() = false

    override fun setupView() {

        myInfoProf.setOnClickListener {
            findNavController().navigate(ProfileFragmentDirections.actionProfileFragmentToMyInformationFragment())
        }

        marinaInfoProf.setOnClickListener {
            findNavController().navigate(ProfileFragmentDirections.actionProfileFragmentToMarinaInfoFragment())
        }

        myReservProf.setOnClickListener {
            findNavController().navigate(ProfileFragmentDirections.actionProfileFragmentToMyReservationsFragment())
        }

        log_out.setOnClickListener {
            findNavController().navigate(ProfileFragmentDirections.actionProfileFragmentToLoginFragment())
        }
    }


}
