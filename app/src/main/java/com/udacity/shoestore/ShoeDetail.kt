package com.udacity.shoestore

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.udacity.shoestore.databinding.FragmentShoeDetailBinding
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.models.ShoeListViewModel

class ShoeDetail : Fragment() {
    private val sharedViewModel: ShoeListViewModel by activityViewModels()
    private val newShoe: Shoe = Shoe("",0.0, "","")

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding: FragmentShoeDetailBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_shoe_detail, container,false)

        binding.shoe = newShoe
        binding.setLifecycleOwner {viewLifecycleOwner.lifecycle}

        binding.saveButton.setOnClickListener { view: View ->

            binding.apply {
                sharedViewModel.addShoe(newShoe)
            }

            view.findNavController().navigateUp()
        }

        binding.cancelButton.setOnClickListener(
            Navigation.createNavigateOnClickListener(R.id.action_shoeDetail_to_shoeList)
        )

        return binding.root
    }

}