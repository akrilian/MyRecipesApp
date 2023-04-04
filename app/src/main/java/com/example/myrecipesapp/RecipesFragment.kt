package com.example.myrecipesapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myrecipesapp.databinding.FragmentRecipesBinding


class RecipesFragment : Fragment(), RecipeAdapter.Listener {

    lateinit var binding : FragmentRecipesBinding

    var recipes = ArrayList<Recipes>()
    lateinit var adapter: RecipeAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var pizza = Recipes(getString(R.string.pizza), getString(R.string.pizza_somei), getString(R.string.pizza_url), getString(R.string.pizza_morei))
        var pasta = Recipes(getString(R.string.pasta), getString(R.string.pasta_somei), getString(R.string.pasta_url), getString(R.string.pasta_morei))
        var salad = Recipes(getString(R.string.salat), getString(R.string.salat_somei), getString(R.string.salat_url), getString(R.string.salat_morei))
        var cake = Recipes(getString(R.string.cake), getString(R.string.cake_somei), getString(R.string.cake_url), getString(R.string.cake_morei))
        var cookies = Recipes(getString(R.string.cookies), getString(R.string.cookies_somei), getString(R.string.cookies_url), getString(R.string.cookies_morei))

        recipes.add(pizza)
        recipes.add(pasta)
        recipes.add(salad)
        recipes.add(cake)
        recipes.add(cookies)
        adapter = RecipeAdapter(this, recipes, this)

        }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentRecipesBinding.inflate(inflater, container,false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val layoutManager = LinearLayoutManager(context)
        binding.ResView.layoutManager = layoutManager
        binding.ResView.adapter = adapter
    }

    override fun onClick(itemView: Int) {
        val bundle = bundleOf(
            InformationFragment.arrayPosition to itemView,
            InformationFragment.name to recipes.get(itemView).name,
            InformationFragment.image to recipes.get(itemView).image,
            InformationFragment.moreInfo to recipes.get(itemView).moreInfo)
                 findNavController().navigate(R.id.action_recipesFragment_to_recipesInfoFragment, bundle)
    }

}