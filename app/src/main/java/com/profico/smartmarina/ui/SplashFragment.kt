package com.profico.smartmarina.ui

import android.os.Handler
import androidx.navigation.fragment.findNavController
import com.profico.smartmarina.R

/**
 * Created by Pero on 21/07/2020.
 */

class SplashFragment : BaseFragment() {

    override fun getLayout() = R.layout.fragment_splash

    override fun hasToolbar() = false

    override fun setupView() {

        Handler().postDelayed({
            findNavController().navigate(SplashFragmentDirections.actionSplashFragmentToLoginFragment())
        }, 1000)
    }
}