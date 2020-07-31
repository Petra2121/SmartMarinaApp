package com.profico.smartmarina.data.model

import com.squareup.moshi.Json

data class SendReservationRequest (
    @Json(name = "numberOfPassengers") val numberOfPassengers2 : Int,
    @Json(name = "dateOfArrival") val dateOfArrival2 : String,
    @Json(name = "dateOfDeparture") val dateOfDeparture2 : String,
    @Json(name = "user") val user2 : String,
    @Json(name = "dock") val dock2 : String,
    @Json(name = "boat") val boat2 : String
)