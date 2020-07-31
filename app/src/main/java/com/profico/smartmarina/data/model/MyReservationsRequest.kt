package com.profico.smartmarina.data.model

import com.squareup.moshi.Json

/**
 * Created by Pero on 22/07/2020
 */
data class MyReservationsRequest(
    @Json(name = "name") val reservationName : String

)