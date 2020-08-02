package com.profico.smartmarina.ui

import android.text.TextUtils
import com.profico.smartmarina.R
import com.profico.smartmarina.data.Repository
import org.koin.core.KoinComponent
import kotlinx.android.synthetic.main.fragment_login.*
import androidx.navigation.fragment.findNavController

/**
 * Created by Pero on 21/07/2020.
 */

class LoginFragment : BaseFragment(), KoinComponent {
    override fun getLayout() = R.layout.fragment_login
    override fun hasToolbar() = false
    override fun setupView() {

        login_button.setOnClickListener {
            val username = login_username.text.toString()
            val pwd = login_password.text.toString()
            if( TextUtils.isEmpty(login_username.text)) {
                login_username.error = "Username is required!";
            }
            else if( TextUtils.isEmpty(login_password.text)) {
                login_password.error = "Password is required!";
            }
            else if (username != "admin") {
                login_username.error = "Wrong username!";
            } else if (pwd != "admin") {
                login_password.error = "Wrong password!";
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