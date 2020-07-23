package com.profico.smartmarina.ui

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.profico.smartmarina.R
import com.profico.smartmarina.data.Repository
import org.koin.core.KoinComponent

import kotlinx.android.synthetic.main.fragment_login.*
import android.widget.Toast
import androidx.navigation.fragment.findNavController


/**
 * Created by Pero on 21/07/2020.
 */
class LoginFragment : BaseFragment(), KoinComponent {

    override fun getLayout() = R.layout.fragment_login

    override fun hasToolbar() = true

    override fun setupView() {
        setToolbarTitle("Login")

        //findNavController().navigate()

        login_button.setOnClickListener {
            findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToHomeScreenFragment())
        }

        /*btn_login.setOnClickListener {
            val username = editText.text.toString()
            Toast.makeText(requireActivity(), "Ime covika je: " + username, Toast.LENGTH_LONG).show()
        }*/
    }


    // Retrofit call example
    // Call method in repository -> Repository fun call retrofit
    fun callServer() {
        Repository().callServer("")
    }
}