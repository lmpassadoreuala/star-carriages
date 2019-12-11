package com.lmpassadore.starcarriages.data.api

import com.lmpassadore.starcarriages.data.api.model.StarshipsResponse
import retrofit2.Call
import retrofit2.http.GET

interface StarshipsApi {

    @GET("api/starships/")
    fun getStarships(): Call<StarshipsResponse>

}