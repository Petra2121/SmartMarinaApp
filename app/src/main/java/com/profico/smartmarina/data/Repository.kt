package com.profico.smartmarina.data

import com.profico.smartmarina.data.model.AddShipsRequest
import com.profico.smartmarina.data.model.AddShipsResponse
import com.profico.smartmarina.data.model.LoginRequest
import com.profico.smartmarina.data.model.LoginResponse
import com.profico.smartmarina.data.remote.ApiService
import org.koin.core.KoinComponent
import org.koin.core.inject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created by Pero on 22/07/2020.
 */
class Repository : KoinComponent {

    private val apiService : ApiService by inject()

    // Example how to call retrofit
    fun callServer(username: String): LoginResponse? {

        var returnValue : LoginResponse? = null

        val request = LoginRequest(userName = username)

        apiService.call(request).enqueue(object : Callback<LoginResponse> {
            override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                if (response.isSuccessful) {
                    returnValue = response.body()
                }
            }
            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {

            }
        })

        return returnValue
    }

    fun callAddServer(boatname: String, regnumber: String, boattype: String, userboat: String): AddShipsResponse? {

        var returnValue : AddShipsResponse? = null

        val request = AddShipsRequest(boatName = boatname, regNumber = regnumber, boatType = boattype, userBoat = userboat)

        apiService.callAdd(request).enqueue(object : Callback<AddShipsResponse> {
            override fun onResponse(call: Call<AddShipsResponse>, response: Response<AddShipsResponse>) {
                if (response.isSuccessful) {
                    returnValue = response.body()
                    println(returnValue)
                }
            }
            override fun onFailure(call: Call<AddShipsResponse>, t: Throwable) {

            }
        })

        return returnValue
    }
}