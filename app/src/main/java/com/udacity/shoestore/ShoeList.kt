package com.udacity.shoestore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.navigation.findNavController
import com.udacity.shoestore.databinding.FragmentShoeListBinding
import com.udacity.shoestore.models.ShoeListViewModel


class ShoeList : Fragment() {
         private var viewModel: ShoeListViewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding: FragmentShoeListBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_shoe_list, container, false
        )

        viewModel = ViewModelProvider(this)[ShoeListViewModel::class.java]

        binding.parentLinearLayout.addView()



        binding.floatingActionButton.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_shoeList_to_shoeDetail)
        }

        return binding.root

    }
}