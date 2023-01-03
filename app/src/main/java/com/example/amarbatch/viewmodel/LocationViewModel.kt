package com.example.amarbatch.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.amarbatch.model.location.UpdateBusLocationResponse
import com.example.amarbatch.utils.RetroInstance
import com.google.gson.JsonObject
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LocationViewModel: ViewModel()
{
    val updateBusLocationLiveData: MutableLiveData<UpdateBusLocationResponse> = MutableLiveData()
    fun getUpdateLocationObserver(): MutableLiveData<UpdateBusLocationResponse>{
        return updateBusLocationLiveData
    }

    fun updateBusLocation(jsonObject: JsonObject){
        val retrofitBuilder = RetroInstance
        val retroInstance = retrofitBuilder.api.updateBusLocation(jsonObject)
        retroInstance.enqueue(object : Callback<UpdateBusLocationResponse>{
            override fun onResponse(
                call: Call<UpdateBusLocationResponse>,
                response: Response<UpdateBusLocationResponse>
            ) {
                updateBusLocationLiveData.postValue(response.body())
                Log.e("nlogResponse",response.body().toString())
            }

            override fun onFailure(call: Call<UpdateBusLocationResponse>, t: Throwable) {
                updateBusLocationLiveData.postValue(null)
                t.localizedMessage?.let { Log.e("nlogFailed", it) }
            }

        })
    }
}