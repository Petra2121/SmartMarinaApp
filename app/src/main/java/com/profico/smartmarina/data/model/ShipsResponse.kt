package com.profico.smartmarina.data.model


import com.squareup.moshi.Json

/**
 * Created by Pero on 22/07/2020.
 */
data class ShipsResponse(
    @Json(name = "data") val data : List<Boats>
)

data class Boats(
    @Json(name = "_id") val shipId : String,
    @Json(name = "name") val shipName : String ,
    @Json(name = "registration_number") val shipRegistration : String,
    @Json(name = "type") val shipType : String
)