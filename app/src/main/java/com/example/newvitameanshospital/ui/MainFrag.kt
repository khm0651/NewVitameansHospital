package com.example.newvitameanshospital.ui

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewOutlineProvider
import androidx.fragment.app.Fragment
import com.example.newvitameanshospital.R
import com.example.newvitameanshospital.databinding.FragmentMainBinding
import com.example.newvitameanshospital.ui.calendar.CalendarAct
import com.example.newvitameanshospital.ui.exercise.ExerciseFrag
import com.example.newvitameanshospital.ui.myblood.BloodFrag
import com.example.newvitameanshospital.ui.notification.NotificationListAct
import com.example.newvitameanshospital.ui.userinfo.UserInfoFrag
import com.example.newvitameanshospital.ui.weight.WeightFrag

class MainFrag : Fragment() {

    lateinit var binding: FragmentMainBinding
    var userInfo = UserInfoFrag()
    var bloodInfo = BloodFrag()
    var weightInfo = WeightFrag()
    var exerciseInfo = ExerciseFrag()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onCreateViewPart()
        onViewCreatedPart()
        binding.apply {

            appbarLayout.outlineProvider = null
            svMain.setOnScrollChangeListener { _, _, scrollY, _, _ ->
                if (scrollY > 0) appbarLayout.outlineProvider = ViewOutlineProvider.BOUNDS
                else appbarLayout.outlineProvider = null
            }

            toolbar.setNavigationOnClickListener {
                mainDrawerLayout.open()
            }

            toolbar.setOnMenuItemClickListener {
                when (it.itemId) {
                    R.id.ic_bell -> {
                        startActivity(Intent(context, NotificationListAct::class.java))
                        true
                    }

                    R.id.ic_calendar -> {
                        startActivity(Intent(context, CalendarAct::class.java))
                        true
                    }

                    else -> false
                }
            }
        }
    }

    private fun onCreateViewPart() {

        userInfo.onCreateView(binding.userInfoFrag.root, viewLifecycleOwner)
        bloodInfo.onCreateView(binding.bloodPressureSugarFrag.root, viewLifecycleOwner)
        weightInfo.onCreateView(binding.weightFrag.root, viewLifecycleOwner)
        exerciseInfo.onCreateView(binding.exerciseFrag.root, viewLifecycleOwner)
    }

    private fun onViewCreatedPart() {
        userInfo.onViewCreated()
        bloodInfo.onViewCreated()
        weightInfo.onViewCreated()
        exerciseInfo.onViewCreated()
    }
}
