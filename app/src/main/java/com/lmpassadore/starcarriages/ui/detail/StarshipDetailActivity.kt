package com.lmpassadore.starcarriages.ui.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.lmpassadore.starcarriages.R

class StarshipDetailActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_STARSHIP = "STARSHIP"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_starship_detail)
    }

}