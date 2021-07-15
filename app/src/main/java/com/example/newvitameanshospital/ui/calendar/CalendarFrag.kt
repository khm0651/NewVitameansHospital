package com.example.newvitameanshospital.ui.calendar

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.newvitameanshospital.databinding.FragmentCalendarBinding

class CalendarFrag : Fragment() {

    lateinit var binding: FragmentCalendarBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCalendarBinding.inflate(inflater, container, false)

        return binding.apply {
            toolbar.setNavigationOnClickListener {
                findNavController().navigateUp()
            }
        }.root
    }
}
