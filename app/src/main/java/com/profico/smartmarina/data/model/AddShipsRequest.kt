package com.profico.smartmarina.data.model

import com.squareup.moshi.Json

data class AddShipsRequest(
    @Json(name = "name") val boatName : String,
    @Json(name = "registration_number") val regNumber : String,
    @Json(name = "type") val boatType : String,
    @Json(name = "user") val userBoat : String
)
