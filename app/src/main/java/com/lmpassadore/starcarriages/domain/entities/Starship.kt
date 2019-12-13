package com.lmpassadore.starcarriages.domain.entities

import android.os.Parcelable
import com.lmpassadore.starcarriages.data.api.model.StarshipResponse
import kotlinx.android.parcel.Parcelize

@Parcelize
class Starship(
    val name: String,
    val model: String,
    val starshipClass: String,
    val manufacturer: String,
    val speed: String,
    val lengthInMeters: String,
    val crewSize: String,
    val passengersCapacity: String,
    val capacity: String
) : Parcelable {

    constructor(starshipResponse: StarshipResponse) : this(
        starshipResponse.name,
        starshipResponse.model,
        starshipResponse.starshipClass,
        starshipResponse.manufacturer,
        starshipResponse.mgltSpeed,
        starshipResponse.lengthInMeters,
        starshipResponse.crewSize,
        starshipResponse.passengersCapacity,
        starshipResponse.capacity
    )

}