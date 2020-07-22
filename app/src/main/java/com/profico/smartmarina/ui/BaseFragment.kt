package com.profico.smartmarina.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.viewModelScope
import com.profico.smartmarina.data.remote.ApiResult
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

/**
 * Created by Pero on 21/07/2020.
 */
abstract class BaseFragment : Fragment() {

    private var mView: View? = null

    abstract fun getLayout() : Int

    abstract fun hasToolbar(): Boolean

    open fun setToolbarTitle(title : String) {
        (activity as AppCompatActivity).title = title
    }

    private var needsViewSetup = true

    abstract fun setupView()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        if (mView == null)
            mView = inflater.inflate(getLayout(), container, false)
        return mView
    }

    override fun onResume() {
        super.onResume()

        if (needsViewSetup) {
            setupView()
            needsViewSetup = false
        }

        (activity as AppCompatActivity).also { activity ->
            if (hasToolbar())
                showToolbar()
            else
                hideToolbar()
        }
    }

    fun hideToolbar() {
        (requireActivity() as AppCompatActivity).supportActionBar?.hide()
    }

    fun showToolbar() {
        (requireActivity() as AppCompatActivity).supportActionBar?.show()
    }

}