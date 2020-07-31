package com.profico.smartmarina.data.model

import com.squareup.moshi.Json

/**
 * Created by Pero on 22/07/2020
 */
data class ShipsRequest(
    @Json(name = "name") val shipName : String
)