package com.example.myrecipesapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.myrecipesapp.databinding.FragmentRecipesInfoBinding

class InformationFragment : Fragment() {

    private lateinit var binding: FragmentRecipesInfoBinding


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentRecipesInfoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recipeName.text = arguments?.getString(name)
        binding.recipeMoreinfo.text = arguments?.getString(moreInfo)
        Glide.with(view).load(arguments?.getString(image)).fitCenter().into(binding.imageRecipe)


    }
    companion object {
        val arrayPosition = "number"
        val name = "name"
        val someInfo = "someInfo"
        val image = "image"
        val moreInfo = "moreInfo"
    }

}
