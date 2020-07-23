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

    override fun hasToolbar() = false

    override fun setupView() {
        setToolbarTitle("Login")
        login_button.setOnClickListener {
            val username = login_username.text.toString()
            val pwd = login_password.text.toString()
            if((username=="admin") && (pwd=="admin")){
                findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToHomeScreenFragment())
            }
            else if((username=="")&&(pwd=="")){
                Toast.makeText(requireActivity(), "Please fill in username and password", Toast.LENGTH_LONG).show()
            }
            else if (username != "admin") {
                Toast.makeText(requireActivity(), "Wrong username", Toast.LENGTH_LONG).show()
            } else if (pwd != "admin") {
                Toast.makeText(requireActivity(), "Wrong password", Toast.LENGTH_LONG).show()
            }
        }
    }
    }


    // Retrofit call example
    // Call method in repository -> Repository fun call retrofit
    fun callServer() {
        Repository().callServer("")
    }