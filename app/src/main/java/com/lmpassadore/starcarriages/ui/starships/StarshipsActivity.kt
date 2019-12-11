package com.lmpassadore.starcarriages.ui.starships

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.lmpassadore.starcarriages.R
import com.lmpassadore.starcarriages.data.api.RetrofitApiClient
import com.lmpassadore.starcarriages.data.api.StarshipsApi
import com.lmpassadore.starcarriages.data.api.model.StarshipsResponse
import com.lmpassadore.starcarriages.domain.entities.Starship
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class StarshipsActivity : AppCompatActivity() {

    companion object {
        private const val BASE_URL = "https://swapi.co"
    }

    private val starshipsClient: StarshipsApi =
        RetrofitApiClient(BASE_URL).createService(StarshipsApi::class.java)

    private lateinit var progressBar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_starships)

        initControls()
        requestStarships()
    }

    private fun initControls() {
        progressBar = findViewById(R.id.starships_loading)
    }

    private fun requestStarships() {

        starshipsClient.getStarships().enqueue(object : Callback<StarshipsResponse> {

            override fun onResponse(call: Call<StarshipsResponse>, response: Response<StarshipsResponse>) {

                progressBar.visibility = View.GONE

                if (response.isSuccessful)
                    setStarshipList(response.body()?.starships?.map { Starship(it) })
                else
                    Toast.makeText(this@StarshipsActivity, R.string.oops_error, Toast.LENGTH_SHORT).show()

            }

            override fun onFailure(call: Call<StarshipsResponse>, t: Throwable) {
                progressBar.visibility = View.GONE
                Toast.makeText(this@StarshipsActivity, R.string.oops_error, Toast.LENGTH_SHORT).show()
            }

        })

    }

    private fun setStarshipList(starships: List<Starship>?) {

        if (starships.isNullOrEmpty())
            return

        val list: RecyclerView = findViewById(R.id.starships_list)
        list.visibility = View.VISIBLE

    }

}
