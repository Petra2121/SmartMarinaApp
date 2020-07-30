package com.profico.smartmarina.data.remote

import com.profico.smartmarina.data.model.*
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

    @GET(ENDPOINT)
    fun call2(): Call<ShipsResponse>

    @GET("reservations?user=5d7a514b5d2c12c7449be040")
    fun callReservations(): Call<MyReservationsResponse>

    @POST(ENDPOINT)
    fun callAdd(
        @Body addShipsRequest: AddShipsRequest
    ): Call<AddShipsResponse>
}
