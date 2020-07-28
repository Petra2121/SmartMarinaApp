package com.profico.smartmarina.data.remote

import com.profico.smartmarina.data.model.AddShipsRequest
import com.profico.smartmarina.data.model.AddShipsResponse
import com.profico.smartmarina.data.model.LoginRequest
import com.profico.smartmarina.data.model.LoginResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

/**
 * Created by Pero on 21/07/2020.
 */

interface ApiService {

    companion object {
        const val ENDPOINT = "boats"
    }

    @POST(ENDPOINT)
    fun call(
        @Body loginRequest: LoginRequest
    ): Call<LoginResponse>

    @POST(ENDPOINT)
    fun callAdd(
        @Body addShipsRequest: AddShipsRequest
    ): Call<AddShipsResponse>
}
