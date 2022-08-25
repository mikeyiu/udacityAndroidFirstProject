package com.udacity.shoestore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.udacity.shoestore.databinding.FragmentWelcomeOnboardingBinding


class WelcomeOnboarding : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentWelcomeOnboardingBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_welcome_onboarding, container,false)
        // Inflate the layout for this fragment
        binding.welcomeOnboardingButton.setOnClickListener(
            Navigation.createNavigateOnClickListener(R.id.action_welcomeOnboarding_to_instruction)
        )
        return binding.root

    }

}