package com.morphylix.android.trainingschedule.presentation.base

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.morphylix.android.trainingschedule.R
import com.morphylix.android.trainingschedule.util.isInternetAvailable

open class BaseFragment<BINDING : ViewBinding>(val inflateFun: (inflater: LayoutInflater, container: ViewGroup?) -> BINDING) :
    Fragment() {

    private var _binding: BINDING? = null
    val binding: BINDING
        get() = _binding!!

    /* Didn't want to support previous API levels because of lack of time. Let's consider that minAPI is 23 */
    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = inflateFun(inflater, container)
        val connected = isInternetAvailable(requireContext())
        if (!connected) {
            makeWarningToast()
        }
        return binding.root
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }

    private fun makeWarningToast() {
        Toast.makeText(
            requireContext(),
            getString(R.string.error, getString(R.string.no_connection)),
            Toast.LENGTH_LONG
        ).show()
    }
}