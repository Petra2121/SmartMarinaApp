package com.profico.smartmarina.data.remote

import com.profico.smartmarina.data.model.*
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

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

    @GET("docks")
    fun callAllDocks2(
        @Query("startDate") startDate2: String,
        @Query("endDate") endDate2: String,
        @Query("type") boatType2: String
    ): Call<GetAllDocksResponse>

}
