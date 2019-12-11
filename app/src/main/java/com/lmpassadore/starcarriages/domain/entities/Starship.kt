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
    val lenghtInMeters: String,
    val crewSize: String,
    val passengersCapacity: String,
    val speed: String,
    val capacity: String
) : Parcelable {

    constructor(starshipResponse: StarshipResponse) : this(
        starshipResponse.name,
        starshipResponse.model,
        starshipResponse.starshipClass,
        starshipResponse.manufacturer,
        starshipResponse.lengthInMeters,
        starshipResponse.crewSize,
        starshipResponse.passengersCapacity,
        starshipResponse.mgltSpeed,
        starshipResponse.capacity
    )

}