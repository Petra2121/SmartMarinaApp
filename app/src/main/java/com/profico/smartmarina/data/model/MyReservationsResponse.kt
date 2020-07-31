package com.profico.smartmarina.data.model


import com.squareup.moshi.Json

/**
 * Created by Pero on 22/07/2020.
 */
data class MyReservationsResponse(
    @Json(name = "bookings") val bookings : Reservations
)

data class Reservations(
    @Json(name = "data") val data : List<MyReservations>


)

data class MyReservations(
    @Json(name = "totalPrice") val reservationTotalPrice : Int,
    @Json(name = "_id") val reservationId : String ,
    @Json(name = "type") val reservationType : String,
    @Json(name = "numberOfPassengers") val reservationNumberOfPassengers : Int,
    @Json(name = "dateOfArrival") val reservationDateOfArrival : String,
    @Json(name = "dateOfDeparture") val reservationDateOfDeparture : String ,
    @Json(name = "created") val reservationCreated : String,
    @Json(name = "boat") val boat : BoatData

    )
data class BoatData(
    @Json(name = "_id") val boatId : String,
    @Json(name = "name") val boatName : String ,
    @Json(name = "registration_number") val boatRegistration : String,
    @Json(name = "type") val boatType : String,
    @Json(name = "user") val boatUser: String
)