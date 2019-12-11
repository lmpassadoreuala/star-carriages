package com.lmpassadore.starcarriages.ui.starships

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.lmpassadore.starcarriages.R
import com.lmpassadore.starcarriages.domain.entities.Starship

class StarshipAdapter(val starships: List<Starship>) :
    RecyclerView.Adapter<StarshipAdapter.StarshipViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StarshipViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.adapter_starship, parent, false)
        return StarshipViewHolder(view)
    }

    override fun onBindViewHolder(holder: StarshipViewHolder, position: Int) {

        val starship = starships[position]

        holder.name.text = starship.name
        holder.model.text = starship.model

    }

    override fun getItemCount(): Int = starships.size

    class StarshipViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val name: TextView = view.findViewById(R.id.starship_name)
        val model: TextView = view.findViewById(R.id.starship_model)

    }

}