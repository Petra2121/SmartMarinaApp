package com.profico.smartmarina.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.profico.smartmarina.R
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_profile.*
import kotlinx.android.synthetic.main.fragment_success.*

/**
 * A simple [Fragment] subclass.
 */
class SuccessFragment : BaseFragment() {
    override fun getLayout() = R.layout.fragment_success

    override fun hasToolbar() = false

    override fun setupView() {
        ok_button.setOnClickListener {
            findNavController().navigate(SuccessFragmentDirections.actionSuccessFragmentToProfileFragment())
        }

    }

    /*override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_success, container, false)
    }*/

}
