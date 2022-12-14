package com.udacity.shoestore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.udacity.shoestore.databinding.FragmentShoeListBinding
import com.udacity.shoestore.databinding.ShoeItemLayoutBinding
import com.udacity.shoestore.models.ShoeListViewModel


class ShoeList : Fragment() {
         private val sharedViewModel: ShoeListViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding: FragmentShoeListBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_shoe_list, container, false
        )

        binding.lifecycleOwner = this

        sharedViewModel.shoeListLiveData.observe(viewLifecycleOwner, Observer { shoeList ->

            for (item in shoeList) {

                val shoeItem = ShoeItemLayoutBinding.inflate(layoutInflater)

                shoeItem.shoe = item
                binding.parentLinearLayout.addView(shoeItem.root)
            }
        })

        binding.floatingActionButton.setOnClickListener (
            Navigation.createNavigateOnClickListener(R.id.action_shoeList_to_shoeDetail)
        )

        return binding.root

    }
}