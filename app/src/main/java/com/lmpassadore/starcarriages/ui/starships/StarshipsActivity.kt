package com.lmpassadore.starcarriages.ui.starships

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.lmpassadore.starcarriages.R
import com.lmpassadore.starcarriages.data.api.RetrofitApiClient
import com.lmpassadore.starcarriages.data.api.StarshipsApi
import com.lmpassadore.starcarriages.data.api.model.StarshipsResponse
import com.lmpassadore.starcarriages.domain.entities.Starship
import com.lmpassadore.starcarriages.ui.detail.StarshipDetailActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class StarshipsActivity : AppCompatActivity() {

    companion object {
        private const val BASE_URL = "https://swapi.co"
    }

    private val starshipsClient: StarshipsApi =
        RetrofitApiClient(BASE_URL).createService(StarshipsApi::class.java)

    private lateinit var starshipsList: RecyclerView
    private lateinit var progressBar: ProgressBar
    private lateinit var retryButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_starships)

        initControls()
        setListeners()

        requestStarships()
    }

    private fun initControls() {
        starshipsList = findViewById(R.id.starships_list)
        progressBar = findViewById(R.id.starships_loading)
        retryButton = findViewById(R.id.starships_retry)
    }

    private fun setListeners() {
        retryButton.setOnClickListener { requestStarships() }
    }

    private fun requestStarships() {

        showProgress()

        starshipsClient.getStarships().enqueue(object : Callback<StarshipsResponse> {

            override fun onResponse(
                call: Call<StarshipsResponse>,
                response: Response<StarshipsResponse>
            ) {

                if (response.isSuccessful) {
                    val starships = response.body()?.starships?.map { Starship(it) }
                    showStarshipList(starships)
                } else
                    showError()

            }

            override fun onFailure(call: Call<StarshipsResponse>, t: Throwable) {
                showError()
            }

        })

    }

    private fun showStarshipList(starships: List<Starship>?) {

        if (starships.isNullOrEmpty())
            return

        starshipsList.visibility = View.VISIBLE
        progressBar.visibility = View.GONE
        retryButton.visibility = View.GONE

        val adapter = StarshipAdapter(starships)
        adapter.listener = object : StarshipAdapter.StarshipListListener {
            override fun onItemClick(starship: Starship) {
                goToStarshipDetail(starship)
            }
        }

        starshipsList.layoutManager = LinearLayoutManager(this)
        starshipsList.adapter = adapter

    }

    private fun showProgress() {

        starshipsList.visibility = View.GONE
        progressBar.visibility = View.VISIBLE
        retryButton.visibility = View.GONE

    }

    private fun showError() {

        Toast.makeText(this@StarshipsActivity, R.string.starships_error, Toast.LENGTH_SHORT).show()

        starshipsList.visibility = View.GONE
        progressBar.visibility = View.GONE
        retryButton.visibility = View.VISIBLE

    }

    private fun goToStarshipDetail(starship: Starship) {
        val detailIntent = Intent(this, StarshipDetailActivity::class.java)
        detailIntent.putExtra(StarshipDetailActivity.EXTRA_STARSHIP, starship)
        startActivity(detailIntent)
    }

}
