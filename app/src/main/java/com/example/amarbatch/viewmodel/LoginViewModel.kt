package com.example.amarbatch.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.amarbatch.utils.RetroInstance
import com.example.amarbatch.model.LoginResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
class LoginViewModel(): ViewModel() {

    val loginLiveData :MutableLiveData<LoginResponse> = MutableLiveData()

    fun getLiveDataObserver(): MutableLiveData<LoginResponse> {
        return loginLiveData
    }

    fun getLoginData()
    {
        val retrofitBuilder = RetroInstance
        val retroInstance = retrofitBuilder.api.getUserCredential()
        retroInstance.enqueue(object : Callback<LoginResponse> {

            override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>
            ) {
                loginLiveData.postValue(response.body())
                Log.e("data",response.body().toString())
            }

            override fun onFailure(
                call: Call<LoginResponse>,
                t: Throwable
            ) {
                loginLiveData.postValue(null)
                Log.e("data","not found")
            }


        })
    }
}