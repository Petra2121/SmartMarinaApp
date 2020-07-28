package com.profico.smartmarina.data.model

import com.squareup.moshi.Json

data class AddShipsResponse (
    @Json(name = "response") val response : String
)