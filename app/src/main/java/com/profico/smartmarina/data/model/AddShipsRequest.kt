package com.profico.smartmarina.data.model

import com.squareup.moshi.Json

data class AddShipsRequest(
    @Json(name = "nameboat") val boatName : String
)
