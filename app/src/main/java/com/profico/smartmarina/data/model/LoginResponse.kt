package com.profico.smartmarina.data.model

import com.squareup.moshi.Json

/**
 * Created by Pero on 22/07/2020.
 */
data class LoginResponse(
    @Json(name = "response") val response : String
)