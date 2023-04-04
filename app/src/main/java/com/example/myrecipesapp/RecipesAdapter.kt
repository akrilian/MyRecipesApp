package com.example.myrecipesapp

import android.location.GnssAntennaInfo.Listener
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myrecipesapp.databinding.ItemRecipesBinding

class RecipeAdapter(
    var fragment: RecipesFragment,
    val recipes: ArrayList<Recipes>,
    val listener: Listener
    ) : RecyclerView.Adapter<RecipeAdapter.RecipesViewHolder>() {

    class RecipesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var textViewRecipeTitle: TextView = itemView.findViewById(R.id.recipeTitle)
        var textViewRecipeSomeInfo: TextView = itemView.findViewById(R.id.recipeSomeInfo)
        var recipeImage: ImageView = itemView.findViewById(R.id.RecipeImage)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipesViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_recipes, parent, false)
        return RecipesViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecipesViewHolder, position: Int) {
        holder.itemView.setOnClickListener {
            listener.onClick(position)
        }
        Glide.with(fragment)
            .load(recipes.get(position).image).fitCenter().into(holder.recipeImage)
        holder.textViewRecipeTitle.text = recipes.get(position).name
        holder.textViewRecipeSomeInfo.text = recipes.get(position).someInfo

    }

    override fun getItemCount(): Int {
        return recipes.size
    }

    interface Listener {
        fun onClick(itemView: Int)
        }
    }


