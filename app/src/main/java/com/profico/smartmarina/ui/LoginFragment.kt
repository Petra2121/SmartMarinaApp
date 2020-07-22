package com.profico.smartmarina.ui

import com.profico.smartmarina.R
import com.profico.smartmarina.data.Repository
import org.koin.core.KoinComponent

/**
 * Created by Pero on 21/07/2020.
 */
class LoginFragment : BaseFragment(), KoinComponent {

    override fun getLayout() = R.layout.fragment_login

    override fun hasToolbar() = true

    override fun setupView() {
        setToolbarTitle("Login")
    }

    // Retrofit call example
    // Call method in repository -> Repository fun call retrofit
    fun callServer() {
        Repository().callServer("")
    }
}