package com.example.newvitameanshospital.ui.diet

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.newvitameanshospital.databinding.FragmentDietBinding

class DietFrag : Fragment() {

    private lateinit var binding: FragmentDietBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDietBinding.inflate(inflater, container, false)
        return binding.root
    }
}
