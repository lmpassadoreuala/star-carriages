package com.lmpassadore.starcarriages.data.api.model

import com.google.gson.annotations.SerializedName

data class StarshipResponse(
    @SerializedName("name")
    val name: String,
    @SerializedName("model")
    val model: String,
    @SerializedName("starship_class")
    val starshipClass: String,
    @SerializedName("manufacturer")
    val manufacturer: String,
    @SerializedName("length")
    val lengthInMeters: String,
    @SerializedName("crew")
    val crewSize: String,
    @SerializedName("passengers")
    val passengersCapacity: String,
    @SerializedName("MGLT")
    val mgltSpeed: String,
    @SerializedName("cargo_capacity")
    val capacity: String

)