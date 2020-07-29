package com.profico.smartmarina.data.model

import com.squareup.moshi.Json

data class GetAllDocksRequest (
    @Json(name = "startDate") val startDate2 : String,
    @Json(name = "endDate") val endDate2 : String,
    @Json(name = "type") val boatType2 : String
)