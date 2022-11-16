package com.example.amarbatch.network

import com.example.amarbatch.model.LoginResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface APIInterface {
    @GET(ApiEndpoint.GET_LOGIN_DATA_BY_PHONE)
    fun getUserCredential(): Call<LoginResponse>
}
