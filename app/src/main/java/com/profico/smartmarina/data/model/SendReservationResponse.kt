package com.profico.smartmarina.data.model

import com.squareup.moshi.Json

data class SendReservationResponse (
    @Json(name = "response") val confirmedReservation : String
)