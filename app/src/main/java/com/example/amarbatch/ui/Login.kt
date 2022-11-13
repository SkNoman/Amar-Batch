package com.example.amarbatch.ui

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.amarbatch.R
import com.example.amarbatch.utils.Constant
import com.example.amarbatch.databinding.FragmentLoginBinding
import com.example.amarbatch.token
import com.google.firebase.messaging.FirebaseMessaging


class Login : Fragment() {

    private lateinit var v: FragmentLoginBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        v = FragmentLoginBinding.inflate(inflater, container, false)

        v.apply {
            btnLogin.setOnClickListener {
                generalLogin()
            }
            ivFacebook.setOnClickListener{
                facebookLogin()
            }
            ivGoogle.setOnClickListener{
                googleLogin()
            }
            ivLinkedin.setOnClickListener{
                linkedinLogin()
            }

        }


        FirebaseMessaging.getInstance().token
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    token = task.result
                    //Log.e("token",task.result.toString())
                    //Toast.makeText(requireContext(), "Token Generation Done", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(requireContext(), "Token Generation Failed", Toast.LENGTH_SHORT).show()
                }
            }
        return v.root
    }

    private fun generalLogin() {
        Toast.makeText(requireContext(),getString(R.string.not_implemented),Toast.LENGTH_SHORT).show()
    }

    private fun linkedinLogin() {
        Toast.makeText(requireContext(),getString(R.string.not_implemented),Toast.LENGTH_SHORT).show()
    }

    private fun googleLogin() {
 /*       val transaction = activity?.supportFragmentManager?.beginTransaction()
        val webView = WebView()
        transaction?.replace(R.id.frameLayout,webView)
        transaction?.disallowAddToBackStack()
        transaction?.commit()*/
        val openManual = Intent(Intent.ACTION_VIEW)
        openManual.data = Uri.parse(Constant.APEX_LOGIN_URL)
        startActivity(openManual)
    }

    private fun facebookLogin() {
        Toast.makeText(requireContext(),getString(R.string.not_implemented),Toast.LENGTH_SHORT).show()
    }
}