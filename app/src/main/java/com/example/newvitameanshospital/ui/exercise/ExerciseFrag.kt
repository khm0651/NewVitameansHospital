package com.example.newvitameanshospital.ui.exercise

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.newvitameanshospital.databinding.FragmentExerciseBinding

class ExerciseFrag: Fragment() {
    private lateinit var binding: FragmentExerciseBinding
    var exerciseList : ArrayList<ExerciseList> = ArrayList()
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        binding = FragmentExerciseBinding.inflate(inflater,container,false)

       // exerciseList = arrayListOf(ExerciseList())
        binding.apply {
            rvExercise.layoutManager=LinearLayoutManager(activity,LinearLayoutManager.VERTICAL,false)
            rvExercise.setHasFixedSize(true)
            rvExercise.adapter=ExerciseAdpater()
        }
        return binding.root
    }
}