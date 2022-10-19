package com.example.amarbatch.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.amarbatch.R
import com.example.amarbatch.databinding.FragmentLoginBinding


class Login : Fragment() {

    private lateinit var v: FragmentLoginBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        v = FragmentLoginBinding.inflate(inflater, container, false)
        v.button.setOnClickListener(View.OnClickListener {
            Toast.makeText(requireContext(),getString(R.string.clicked),Toast.LENGTH_SHORT).show()
        })

        return v.root
    }
}