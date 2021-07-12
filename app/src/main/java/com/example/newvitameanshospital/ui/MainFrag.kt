package com.example.newvitameanshospital.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.newvitameanshospital.R
import com.example.newvitameanshospital.databinding.FragmentMainBinding
import com.example.newvitameanshospital.ui.myblood.BloodFrag
import com.example.newvitameanshospital.ui.weight.WeightFragment

class MainFrag : Fragment() {

    lateinit var binding: FragmentMainBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val weightFrag = WeightFragment()
        val bloodFrag = BloodFrag()
        val manager = childFragmentManager
        val transaction = manager.beginTransaction()
        transaction.add(R.id.blood_pressure_sugar_frag,bloodFrag,bloodFrag.javaClass.name)
        transaction.add(R.id.weight_frag,weightFrag,weightFrag.javaClass.name)
        transaction.commit()

    }

}