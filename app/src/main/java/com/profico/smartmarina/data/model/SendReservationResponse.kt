package com.profico.smartmarina.data.model

import com.squareup.moshi.Json

data class SendReservationResponse (
    @Json(name = "data") val confirmedReservation : SendReservationResponseData
)

data class SendReservationResponseData(
    @Json (name= "_id") val resid: String
)


