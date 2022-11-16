package com.example.amarbatch.ui

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.amarbatch.R
import com.example.amarbatch.databinding.FragmentLoginBinding
import com.example.amarbatch.model.LoginResponse
import com.example.amarbatch.network.ApiEndpoint
import com.example.amarbatch.token
import com.example.amarbatch.utils.Constant
import com.example.amarbatch.viewmodel.LoginViewModel
import com.google.firebase.messaging.FirebaseMessaging
import retrofit2.Call
import retrofit2.http.GET


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
                if (loginValidation()){
                    generalLogin()
                }

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

    private fun loginValidation(): Boolean {
        if (v.etPhone.text.toString().isEmpty()){
            Toast.makeText(requireContext(),"Please enter phone number",Toast.LENGTH_SHORT).show()
            return false
        }else if (v.etPassword.text.toString().isEmpty()){
            Toast.makeText(requireContext(),"Please enter password",Toast.LENGTH_SHORT).show()
            return false
        }
        return true
    }

    interface MyApiInterface {
        @GET(ApiEndpoint.GET_LOGIN_DATA_BY_PHONE+"01608983444")
        fun getUserCredential(): Call<LoginResponse>
    }
    private fun generalLogin() {
     v.progressBar.visibility = View.VISIBLE
     val viewModel: LoginViewModel = ViewModelProvider(this)[LoginViewModel::class.java]
      viewModel.getLiveDataObserver().observe(viewLifecycleOwner) {

          if (it.items[0].password.isNotEmpty()) {
             if (v.etPassword.text.toString() == it.items[0].password){
                 v.progressBar.visibility = View.GONE
                 Toast.makeText(requireContext(), getString(R.string.thankyou)+it.items[0].user_name, Toast.LENGTH_SHORT).show()
                 val transaction = activity?.supportFragmentManager?.beginTransaction()
                 val webView = WebView()
                 transaction?.replace(R.id.frameLayout,webView)
                 transaction?.disallowAddToBackStack()
                 transaction?.commit()
             }else{
                 v.progressBar.visibility = View.GONE
                 Toast.makeText(requireContext(),getString(R.string.wrong_credentials),Toast.LENGTH_SHORT).show()
             }
          } else {
              v.progressBar.visibility = View.GONE
              Toast.makeText(requireContext(),getString(R.string.sww),Toast.LENGTH_SHORT).show()
          }
      }
      viewModel.getLoginData()
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