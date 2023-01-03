package com.example.amarbatch.utils

import com.example.amarbatch.network.APIInterface
import com.example.amarbatch.ui.Login
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object RetroInstance {
    private val retrofit by lazy{
        Retrofit.Builder().baseUrl(Constant.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    val api: APIInterface by lazy {
        retrofit.create(APIInterface::class.java)
    }
}




