package com.profico.smartmarina.data.remote

import java.io.IOException

/**
 * Created by Pero on 25/05/2020.
 */
sealed class ApiResult<out T : Any> {

    data class Success<out T : Any>(val data: T): ApiResult<T>()
    data class Error(val exception: IOException): ApiResult<Nothing>()
}