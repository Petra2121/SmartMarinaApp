package com.profico.smartmarina.data.model

import com.squareup.moshi.Json

data class GetAllDocksResponse (
    @Json(name = "free") val allDocks : List<Dokovi>
)

data class Dokovi (
    @Json(name = "_id") val id2: String,
    @Json(name = "number") val number2 : String,
    @Json(name = "offeringPrice") val price2 : String,
    @Json(name = "position") val position2 : String,
    @Json(name = "long") val long2 : String,
    @Json(name = "lat") val lat2 : String
)


