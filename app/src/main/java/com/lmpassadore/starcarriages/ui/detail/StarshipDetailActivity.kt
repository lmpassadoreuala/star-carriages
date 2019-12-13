package com.lmpassadore.starcarriages.ui.detail

import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.lmpassadore.starcarriages.R
import com.lmpassadore.starcarriages.domain.entities.Starship

class StarshipDetailActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_STARSHIP = "STARSHIP"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_starship_detail)

        setSupportActionBar(findViewById(R.id.starship_detail_toolbar))
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Details"

        val starship: Starship = intent.extras?.getParcelable<Starship>(EXTRA_STARSHIP) as Starship
        initControls(starship)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if (item.itemId == android.R.id.home) {
            onBackPressed()
            return true
        }

        return super.onOptionsItemSelected(item)
    }

    private fun initControls(starship: Starship) {

        val name: TextView = findViewById(R.id.starship_detail_name)
        name.text = starship.name

        val model: TextView = findViewById(R.id.starship_detail_model)
        model.text = starship.model

        val starshipClass: TextView = findViewById(R.id.starship_detail_class)
        starshipClass.text = starship.starshipClass

        val manufacturer: TextView = findViewById(R.id.starship_detail_manufacturer)
        manufacturer.text = starship.manufacturer

        val speed: TextView = findViewById(R.id.starship_detail_speed)
        speed.text = starship.speed

        val length: TextView = findViewById(R.id.starship_detail_length)
        length.text = starship.lengthInMeters

        val crew: TextView = findViewById(R.id.starship_detail_crew)
        crew.text = starship.crewSize

        val passengers: TextView = findViewById(R.id.starship_detail_passengers)
        passengers.text = starship.passengersCapacity

        val cargo: TextView = findViewById(R.id.starship_detail_capacity)
        cargo.text = starship.capacity

    }

}