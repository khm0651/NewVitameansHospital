package com.example.newvitameanshospital.ui.exercise

import android.view.View
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.newvitameanshospital.databinding.FragmentExerciseBinding
import com.example.newvitameanshospital.ui.VitaMainFragPart

class ExerciseFrag : VitaMainFragPart<FragmentExerciseBinding>() {
    var exerciseList: ArrayList<ExerciseList> = ArrayList()

    override fun onCreateView(view: View, lifecycleOwner: LifecycleOwner) {
        super.onCreateView(view, lifecycleOwner)
        binding.apply {
            rvExercise.layoutManager = LinearLayoutManager(context)
            rvExercise.setHasFixedSize(true)
            rvExercise.adapter = ExerciseAdpater()
        }
    }

    override fun onViewCreated() {
    }
}
