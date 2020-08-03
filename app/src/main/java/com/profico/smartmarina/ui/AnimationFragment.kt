package com.profico.smartmarina.ui
import android.os.Handler
import androidx.navigation.NavArgs
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.profico.smartmarina.R
/**
 * Created by Pero on 21/07/2020.
 */
class AnimationFragment : BaseFragment() {
    val args : AnimationFragmentArgs by navArgs()
    override fun getLayout() = R.layout.fragment_animation
    override fun hasToolbar() = false
    override fun setupView() {
        Handler().postDelayed({
            findNavController().navigate(AnimationFragmentDirections.actionAnimationFragmentToSuccessFragment(args.resId))
        }, 5000)
    }
}