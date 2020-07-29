package com.profico.smartmarina.ui

import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.profico.smartmarina.R
import com.profico.smartmarina.data.Repository
import org.koin.core.KoinComponent
import kotlinx.android.synthetic.main.fragment_login.*
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_payment.*


/**
 * Created by Pero on 21/07/2020.
 */
class LoginFragment : BaseFragment(), KoinComponent {
    override fun getLayout() = R.layout.fragment_login
    override fun hasToolbar() = false
    override fun setupView() {
        //setToolbarTitle("Login")
        login_button.setOnClickListener {
            val username = login_username.text.toString()
            val pwd = login_password.text.toString()
            if( TextUtils.isEmpty(login_username.getText())) {
                login_username.setError("Username is required!");
            }
            else if( TextUtils.isEmpty(login_password.getText())) {
                login_password.setError("Password is required!");
            }
            else if (username != "admin") {
                login_username.setError("Wrong username!");
            } else if (pwd != "admin") {
                login_password.setError("Wrong password!");
            }
            else if((username=="admin") && (pwd=="admin")){
                findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToHomeScreenFragment())
            }
        }
    }
}
// Retrofit call example
// Call method in repository -> Repository fun call retrofit
fun callServer() {
    Repository().callServer("")

   // Repository().callServer("")
}