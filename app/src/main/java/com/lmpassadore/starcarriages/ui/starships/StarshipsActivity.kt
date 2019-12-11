package com.lmpassadore.starcarriages.ui.starships

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.lmpassadore.starcarriages.R
import com.lmpassadore.starcarriages.data.api.RetrofitApiClient
import com.lmpassadore.starcarriages.data.api.StarshipsApi
import com.lmpassadore.starcarriages.data.api.model.StarshipsResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class StarshipsActivity : AppCompatActivity() {

    companion object {
        private const val BASE_URL = "https://swapi.co"
    }

    private val starshipsClient: StarshipsApi =
        RetrofitApiClient(BASE_URL).createService(StarshipsApi::class.java)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_starships)

        requestStarships()
    }

    private fun requestStarships() {

        starshipsClient.getStarships().enqueue(object : Callback<StarshipsResponse> {

            override fun onResponse(
                call: Call<StarshipsResponse>,
                response: Response<StarshipsResponse>
            ) {
                Toast.makeText(this@StarshipsActivity, "OK", Toast.LENGTH_SHORT).show()
            }

            override fun onFailure(call: Call<StarshipsResponse>, t: Throwable) {
                Toast.makeText(this@StarshipsActivity, "Error", Toast.LENGTH_SHORT).show()
            }

        })

    }

}
