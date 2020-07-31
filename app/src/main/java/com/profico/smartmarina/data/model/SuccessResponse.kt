package com.profico.smartmarina.data.model

import com.squareup.moshi.Json

data class SuccessResponse (
    @Json(name = "bookings") val Res : Data
)

data class Data(
    @Json (name="data") val Data : List<Reservation>
)

data class Reservation (
    @Json(name = "_id") val id2: String,
    @Json(name = "dateOfArrival") val dateOfArrival2 : String,
    @Json(name = "dateOfDeparture") val dateOfDeparture2 : String,
    @Json(name = "dockNumber") val dockNumber2 : String,
    @Json(name = "boatRegistrationNumber") val boatRegistrationNumber2 : String,
    @Json(name = "totalPrice") val totalPrice2 : String
)