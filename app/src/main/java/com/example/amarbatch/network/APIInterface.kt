package com.example.amarbatch.network

import com.example.amarbatch.model.LoginResponse
import com.example.amarbatch.model.location.UpdateBusLocationResponse
import com.google.gson.JsonObject
import org.json.JSONObject
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.Query

interface APIInterface {
    @GET(ApiEndpoint.GET_LOGIN_DATA_BY_PHONE+"01608983444")
    fun getUserCredential(): Call<LoginResponse>

    @Headers("Content-Type: application/json")
    @POST(ApiEndpoint.UPDATE_BUS_LOCATION)
    fun updateBusLocation(@Body jsonObject: JsonObject): Call<UpdateBusLocationResponse>
}
