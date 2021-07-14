package com.example.newvitameanshospital.ui.myblood

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.newvitameanshospital.databinding.FragmentBloodBinding

class BloodFrag : Fragment() {
    private lateinit var binding: FragmentBloodBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBloodBinding.inflate(inflater, container, false)
        return binding.root
    }
}
