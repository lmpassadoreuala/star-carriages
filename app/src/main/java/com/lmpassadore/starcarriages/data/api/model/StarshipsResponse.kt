package com.lmpassadore.starcarriages.data.api.model

import com.google.gson.annotations.SerializedName

data class StarshipsResponse(
    @SerializedName("results")
    val starships: List<StarshipResponse>
)