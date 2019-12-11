package com.lmpassadore.starcarriages.data.api

import com.lmpassadore.starcarriages.data.api.model.StarshipResponse
import retrofit2.Call
import retrofit2.http.GET

interface StarshipsApi {

    @GET("api/starships/")
    fun getStarships(): Call<List<StarshipResponse>>

}